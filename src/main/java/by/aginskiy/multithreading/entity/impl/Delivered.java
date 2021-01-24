package by.aginskiy.multithreading.entity.impl;

import by.aginskiy.multithreading.entity.Car;
import by.aginskiy.multithreading.entity.CarState;

public class Delivered implements CarState {

    @Override
    public void nextAction(Car car) {
        throw new UnsupportedOperationException("The car " + car.getId() + " was delivered and does not have any actions");
    }
}
