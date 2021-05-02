package com.study.domain;

/**
 * @author Jaedoo Lee
 */
public class Car implements Comparable<Car> {
    private final String name;
    private final Engine engine;
    private int position;

    public Car(String name, int position, Engine engine) {
        this.name = name;
        this.position = position;
        this.engine = engine;
    }

    public void move() {
        this.engine.accelate();
        this.position += engine.getPower();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car car) {
        if (this.position < car.position) {
            return 1;
        } else if (this.position == car.position) {
            return 0;
        }

        return -1;
    }
}
