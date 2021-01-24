package by.aginskiy.multithreading.entity.impl;

import by.aginskiy.multithreading.entity.CarState;
import by.aginskiy.multithreading.entity.Car;
import by.aginskiy.multithreading.entity.Ferry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Newcomer implements CarState {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void nextAction(Car car) {
        Ferry.getInstance().loadFerry(car);
        car.setCarState(new Transfer());
    }
}
