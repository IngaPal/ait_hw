package homework26.cars.model;

public class Car {
    String regNumber;
    String model;
    String company;
    double engine;
    String color;

    public Car(String regNumber, String model, String company, double engine, String color) {
        this.regNumber = regNumber;
        this.model = model;
        this.company = company;
        this.engine = engine;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public double getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return regNumber.equals(car.regNumber);
    }

    @Override
    public int hashCode() {
        return regNumber.hashCode();
    }
}
