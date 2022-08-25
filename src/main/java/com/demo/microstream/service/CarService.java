package com.demo.microstream.service;

import com.demo.microstream.config.DataRoot;
import com.demo.microstream.exception.CarException;
import com.demo.microstream.model.Car;
import lombok.AllArgsConstructor;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class CarService {
    
    private final DataRoot dataRoot;
    private final EmbeddedStorageManager storeManager;

    public List<Car> findAll() {
        return dataRoot.getCars();
    }

    public Car find(Integer id) throws CarException {
        return IntStream.range(0, dataRoot.getCars().size())
                .filter(index -> dataRoot.getCars().get(index).getId() == id)
                .mapToObj(index -> dataRoot.getCars().get(index).setIndex(index))
                .findFirst()
                .orElseThrow(() -> new CarException("Not found card by id " + id));
    }

    public Car save(Car car) {
        dataRoot.getCars().add(car);
        storeManager.store(dataRoot.getCars());
        return car;
    }

    public Car update(Car car) throws CarException {
        var c = dataRoot.getCars().set(find(car.getId()).getIndex(), car);
        storeManager.store(dataRoot.getCars());
        return c;
    }

    public void delete(Integer id) throws CarException {
        dataRoot.getCars().remove(find(id));
        storeManager.store(dataRoot.getCars());
    }
    
}
