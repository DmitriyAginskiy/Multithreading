package by.aginskiy.multithreading.util;

public class IdGenerator {

    private static long id;

    private IdGenerator() {

    }

    public static long getId() {
        return id++;
    }
}
