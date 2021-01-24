package by.aginskiy.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class Platform {

    private static final int SQUARE = 10;
    private static final int LOAD_CAPACITY = 15;

    private List<Car> cars;

    public Platform() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void clear() {
        cars.clear();
    }

    public boolean isHaveSpace(Car car) {
        int square = 0;
        int loadCapacity = 0;
        for(Car c : cars) {
            square += c.getType().getSquare();
            loadCapacity += c.getType().getWeight();
        }
        return (square + car.getType().getSquare() <= SQUARE) && (loadCapacity + car.getType().getWeight() <= LOAD_CAPACITY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform = (Platform) o;

        return cars != null ? cars.equals(platform.cars) : platform.cars == null;
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Platform{");
        sb.append("cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}
