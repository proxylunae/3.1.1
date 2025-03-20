package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 3, "Black"));
        cars.add(new Car("Audi", 2, "White"));
        cars.add(new Car("Lada", 1, "Red"));
        cars.add(new Car("Opel", 4, "Blue"));
        cars.add(new Car("Mercedes", 5, "Green"));
        return "index";
    }
}
