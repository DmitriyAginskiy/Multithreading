package by.aginskiy.multithreading.builder;

import by.aginskiy.multithreading.entity.Car;
import by.aginskiy.multithreading.entity.CarType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CarSequenceBuilder {

    private static final String SPLIT_REGEX = " ";

    public static List<Car> createCarSequence(List<String> carsValues) {
        List<Car> cars = new ArrayList<>();
        String[] carValues;
        for(int i = 0; i < carsValues.size(); i++) {
            carValues = carsValues.get(i).split(SPLIT_REGEX);
            String number = carValues[0];
            CarType carType = CarType.valueOf(carValues[1].toUpperCase(Locale.ROOT));
            cars.add(new Car(number, carType));
        }
        return cars;
    }
}
