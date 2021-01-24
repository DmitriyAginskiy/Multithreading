package by.aginskiy.multithreading.entity.impl;

import by.aginskiy.multithreading.entity.CarState;
import by.aginskiy.multithreading.entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Transfer implements CarState {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void nextAction(Car car) {
        car.setCarState(new Delivered());
        logger.info("The car " + car.getId() + " was delivered");
    }
}
