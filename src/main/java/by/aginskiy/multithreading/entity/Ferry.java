package by.aginskiy.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {

    private static final Logger logger = LogManager.getLogger();
    private static final int PLATFORM_NUMBER = 10;
    private static Ferry ferry;
    private List<Platform> platforms = new ArrayList<>();
    private static Lock locker = new ReentrantLock(true);

    private Ferry() {
        for(int i = 0; i < PLATFORM_NUMBER; i++) {
            platforms.add(new Platform());
        }
    }

    public static Ferry getInstance() {
        if (ferry == null) {
            locker.lock();
            if (ferry == null) {
                ferry = new Ferry();
            }
            locker.unlock();
        }
        return ferry;
    }

    public Optional<Platform> getAvailablePlatform(Car car) {
        Optional<Platform> platform = Optional.empty();
        int counter = 0;
        while(counter < PLATFORM_NUMBER) {
            if(platforms.get(counter).isHaveSpace(car)) {
                platform = Optional.of(platforms.get(counter));
                break;
            }
            counter++;
        }
        return platform;
    }

    public void loadFerry(Car car) {
        try {
            locker.lock();
            Optional<Platform> availablePlatform = getAvailablePlatform(car);
            if(availablePlatform.isEmpty()) {
                moveCars();
                car.getCarState().nextAction(car);
                TimeUnit.SECONDS.sleep(3);
                availablePlatform = Optional.of(platforms.get(0));
                logger.info("All the cars were ferried to the other side");
            }
            availablePlatform.get().addCar(car);
            TimeUnit.MILLISECONDS.sleep(200);
            logger.info("Car " + car.getId() + " was added to ferry");
        } catch (InterruptedException exception) {
            logger.error("An exception occurred while trying to put the thread to sleep");
        } finally {
            locker.unlock();
        }
    }

    public void moveCars() {
        for(int i = 0; i < platforms.size(); i++) {
            platforms.get(i).clear();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ferry{");
        sb.append("platforms=").append(platforms);
        sb.append('}');
        return sb.toString();
    }
}
