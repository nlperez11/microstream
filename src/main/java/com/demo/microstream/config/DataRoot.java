package com.demo.microstream.config;

import com.demo.microstream.exception.CarException;
import com.demo.microstream.model.Car;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Data
public class DataRoot {

    private List<Car> cars = new ArrayList<>();

    public Car find(Integer id) throws CarException {
        return IntStream.range(0, this.getCars().size())
                .filter(index -> this.getCars().get(index).getId() == id)
                .mapToObj(index -> this.getCars().get(index).setIndex(index))
                .findFirst()
                .orElseThrow(() -> new CarException("Not found card by id " + id));
    }

    public Car save(Car car) {
        this.cars.add(car);
        return car;
    }

    public Car update(Car car) throws CarException {
        return this.getCars().set(find(car.getId()).getIndex(), car);
    }

    public void delete(Integer id) throws CarException {
        this.getCars().remove(find(id));
    }

}