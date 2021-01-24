package by.aginskiy.multithreading.entity;

public enum CarType {

    PASSENGER (1, 1),
    TRUCK (2, 3);

    private int square;
    private int weight;

    CarType(int square, int weight) {
        this.square = square;
        this.weight = weight;
    }

    public int getSquare() {
        return square;
    }

    public int getWeight() {
        return weight;
    }
}
