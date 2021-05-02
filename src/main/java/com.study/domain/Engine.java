package com.study.domain;

/**
 * @author Jaedoo Lee
 */
public class Engine {
    protected int horsePower;

    protected void accelate() { this.horsePower = 0; }

    protected int getPower() {
        return this.horsePower;
    }
}
