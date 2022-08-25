package com.demo.microstream.controller;

import com.demo.microstream.exception.CarException;
import com.demo.microstream.model.Car;
import com.demo.microstream.service.CarService;
import lombok.AllArgsConstructor;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("micro-stream/car")
@AllArgsConstructor
public class CarController {

    private final CarService service;
    private final EmbeddedStorageManager storageManager;

    @PostMapping
    public List<Car> save(@RequestBody List<Car> cars) {
        var list = cars.stream().map(service::save).collect(Collectors.toList());
        storageManager.storeRoot();
        return list;
    }

    @GetMapping
    public List<Car> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Car getAll(@PathVariable Integer id) throws CarException {
        return service.find(id);
    }

    @PutMapping
    public Car update(@RequestBody Car car) throws CarException {
        return service.update(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) throws CarException {
        service.delete(id);
    }


}
