package com.demo.microstream.controller;

import com.demo.microstream.config.DataRoot;
import com.demo.microstream.exception.CarException;
import com.demo.microstream.model.Car;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@RestController
@RequestMapping("micro-stream")
@AllArgsConstructor
@Slf4j
public class HelloController {

    private final DataRoot dataRoot;

    @PostMapping
    public List<Car> save(@RequestBody List<Car> cars) {
        cars.forEach(dataRoot::save);
        return cars;
    }

    @GetMapping
    public List<Car> getAll() {
        return dataRoot.getCars();
    }

    @GetMapping("/{id}")
    public Car getAll(@PathVariable Integer id) throws CarException {
        return dataRoot.find(id);
    }

    @PutMapping
    public Car update(@RequestBody Car car) throws CarException {
        return dataRoot.update(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) throws CarException {
        dataRoot.delete(id);
    }


}
