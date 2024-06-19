package homework26.cars.test;

import homework26.cars.dao.Garage;
import homework26.cars.dao.GarageImpl;
import homework26.cars.model.Car;
import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        cars = new Car[4];
        cars[0] = new Car("AAA111", "BMW", "Germany", 1.6, "black");
        cars[1] = new Car("BBB222", "Mercedes", "Italy", 2.0, "blue");
        cars[2] = new Car("CCC333", "Volkswagen", "Norway", 1.2, "red");
        cars[3] = new Car("DDD444", "Audi", "Canada", 1.7, "white");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @org.junit.jupiter.api.Test
    void addCar() {
        assertFalse(garage.addCar(cars[0]));
        Car car = new Car("FFF555", "Ford", "USA", 2.0, "Green");
        assertTrue(garage.addCar(car));
        car = new Car("GGG666", "Toyota", "Japan", 1.4, "Yellow");
        assertFalse(garage.addCar(car));
    }

    @org.junit.jupiter.api.Test
    void removeCar() {
        assertEquals(cars[3], garage.removeCar("DDD444"));
        assertEquals(3, garage.quantity());
        assertNull(garage.removeCar("DDD444"));
    }

    @org.junit.jupiter.api.Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("AAA111");
        assertEquals(cars[0], car);
    }

    @org.junit.jupiter.api.Test
    void findCarsByModel() {
        Car[] carsByModel = garage.findCarsByModel("BMW");
        assertEquals(4, carsByModel.length);
        assertEquals(cars[0], carsByModel[0]);
    }

    @org.junit.jupiter.api.Test
    void findCarsByCompany() {
        Car[] carsByCompany = garage.findCarsByCompany("Germany");
        assertEquals(4, carsByCompany.length);
        assertEquals(cars[0], carsByCompany[0]);
    }

    @org.junit.jupiter.api.Test
    void findCarsByEngine() {
        Car[] carsByEngine = garage.findCarsByEngine(1.2, 2.0);
        assertEquals(4, carsByEngine.length);
        assertEquals(cars[0], carsByEngine[0]);

    }

    @org.junit.jupiter.api.Test
    void findCarsByColor() {
        Car[] carsByColor = garage.findCarsByColor("black");
        assertEquals(4, carsByColor.length);
        assertEquals(cars[0], carsByColor[0]);
    }
    @org.junit.jupiter.api.Test
    void quantity() {
        assertEquals(4, garage.quantity());
    }
}

