package com.sofka.randomgenerate.co.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Random {

    private Date date;
    @Id
    private String id;
    private String originalList;
    private String ramdomList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalList() {
        return originalList;
    }

    public void setOriginalList(String originalList) {
        this.originalList = originalList;
    }

    public String getRamdomList() {
        return ramdomList;
    }

    public void setRamdomList(String ramdomList) {
        this.ramdomList = ramdomList;
    }
}
