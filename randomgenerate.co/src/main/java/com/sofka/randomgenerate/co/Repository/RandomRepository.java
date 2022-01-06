package com.sofka.randomgenerate.co.Repository;

import com.sofka.randomgenerate.co.Collection.Random;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RandomRepository extends ReactiveCrudRepository<Random, String> {


}
