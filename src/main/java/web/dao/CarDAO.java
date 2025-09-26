package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {
    private static int CAR_COUNT;
    private List<Car> cars;

    {
        this.cars = new ArrayList<Car>();
        this.cars.add(new Car(++CAR_COUNT, "BMW", "Black"));
        this.cars.add(new Car(++CAR_COUNT, "Audi", "Yellow"));
        this.cars.add(new Car(++CAR_COUNT, "Ferrari", "Red"));
        this.cars.add(new Car(++CAR_COUNT, "Mercedes", "Blue"));
        this.cars.add(new Car(++CAR_COUNT, "Toyota", "Silver"));
    }

    public List<Car> carsList() {
        return this.cars;
    }

    public List<Car> showCars(int count) {

        return cars.stream().limit(Math.min(count, cars.size())).collect(Collectors.toList());
    }
}
