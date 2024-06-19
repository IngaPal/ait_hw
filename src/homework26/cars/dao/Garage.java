package homework26.cars.dao;
import homework26.cars.model.Car;

import java.util.function.Predicate;

public interface Garage {

    boolean addCar(Car car);
    Car removeCar(String regNumber);
    Car findCarByRegNumber(String regNumber);
    Car[] findCarsByModel(String model);
    Car[] findCarsByCompany(String company);
    Car[] findCarsByEngine(double min, double max);
    Car[] findCarsByColor(String color);
    Car[] findCarsByPredicate(Predicate<Car> predicate);
    int quantity();
}