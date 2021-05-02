package com.study.domain;

import java.util.Random;

/**
 * @author Jaedoo Lee
 */
public class RandomEngine extends Engine {
    private static final int ENGINE_LIMITED = 9;
    private static final int CONTROLLER = 4;
    private static final int MOVE = 1;
    private static final int STOP = 0;

    @Override
    protected void accelate() {
        this.horsePower = new Random().nextInt(ENGINE_LIMITED);
    }

    @Override
    protected int getPower() {
        if (this.horsePower >= CONTROLLER)   return MOVE;
        return STOP;
    }

}
