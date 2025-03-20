package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 3, "Black"));
        cars.add(new Car("Audi", 2, "White"));
        cars.add(new Car("Lada", 1, "Red"));
        cars.add(new Car("Opel", 4, "Blue"));
        cars.add(new Car("Mercedes", 5, "Green"));
    }


    @Override
    public List<Car> getCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }
}
