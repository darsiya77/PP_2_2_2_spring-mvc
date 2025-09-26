package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService<Car> {
    private static int CAR_COUNT;
    private final List<Car> cars;

    {
        this.cars = new ArrayList<>();
        this.cars.add(new Car(++CAR_COUNT, "BMW", "Black"));
        this.cars.add(new Car(++CAR_COUNT, "Audi", "Yellow"));
        this.cars.add(new Car(++CAR_COUNT, "Ferrari", "Red"));
        this.cars.add(new Car(++CAR_COUNT, "Mercedes", "Blue"));
        this.cars.add(new Car(++CAR_COUNT, "Toyota", "Silver"));
    }

    @Override
    public List<Car> showCars(Integer count) {
        if (count == null) {
            return cars;
        } else {
            return cars.stream().limit(Math.min(count, cars.size())).collect(Collectors.toList());
        }
    }
}
