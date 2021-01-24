package by.aginskiy.multithreading.main;

import by.aginskiy.multithreading.builder.CarSequenceBuilder;
import by.aginskiy.multithreading.exception.FileReadingException;
import by.aginskiy.multithreading.entity.Car;
import by.aginskiy.multithreading.reader.CarReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarReader reader = new CarReader();
        List<Car> cars;
        try {
            List<String> values = reader.readFromFile("DEFAULT");
            cars = CarSequenceBuilder.createCarSequence(values);
            for(int i = 0; i < cars.size(); i++) {
                cars.get(i).run();
            }
        } catch (FileReadingException e) {
            e.printStackTrace();
        }
    }
}
