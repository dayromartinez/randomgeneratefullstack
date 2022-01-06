package com.sofka.randomgenerate.co.Controller;

import com.sofka.randomgenerate.co.Collection.Random;
import com.sofka.randomgenerate.co.Repository.RandomRepository;
import com.sofka.randomgenerate.co.DTO.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class RandomController {

    private RandomRepository randomRepository;

    @Autowired
    public RandomController(RandomRepository randomRepository){
        this.randomRepository = randomRepository;
    }

    @PostMapping("")
    public Mono<Random> post(@RequestBody RequestDTO requestDTO){
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setOriginalList(requestDTO.getList());
            return entity;
        }).map(entity -> {
            var list = Stream.of(requestDTO.getList().split(","))
                    .map(p -> p.trim())
                    .collect(Collectors.toList());
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRamdomList(randomList);
            return entity;
        }).flatMap(randomRepository::save);
    }

    @GetMapping("")
    public Flux<Random> get(){
        return randomRepository.findAll();
    }
}
