package com.demo.microstream.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Car {

    private int id;
    private String brand;
    private int year;

    @JsonIgnore
    private Integer index;

    public Car setIndex(int index) {
        this.index = index;
        return this;
    }
}
