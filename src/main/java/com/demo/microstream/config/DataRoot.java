package com.demo.microstream.config;

import com.demo.microstream.model.Car;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataRoot {

    private List<Car> cars = new ArrayList<>();
    private String params;

}