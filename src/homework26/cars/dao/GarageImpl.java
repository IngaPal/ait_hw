package homework26.cars.dao;
import homework26.cars.model.Car;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
        size = 0;
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size] = car;
        size++;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car removedCar = cars[i];
                for (int j = i; j < size - 1; j++) {
                    cars[j] = cars[j + 1];
                }
                size--;
                return removedCar;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {

        return findCarsByPredicate(car -> car.getModel().equals(model));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(car -> car.getCompany().equals(company));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(car -> car.getEngine() >= min && car.getEngine() <= max);
    }

    @Override
    public Car[] findCarsByColor(String color) {

        return findCarsByPredicate(car -> car.getColor().equals(color));
    }

    @Override
    public Car[] findCarsByPredicate(Predicate<Car> predicate) {

        int count = 0;
        Car[] foundCars = new Car[size];
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                foundCars[count] = cars[i];
                count++;
            }
        }
        return foundCars;
    }
    @Override
    public int quantity() {
        return size;
    }
}
