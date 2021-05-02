package com.study.application;

import com.study.domain.Cars;
import com.study.domain.GameConstants;

/**
 * @author Jaedoo Lee
 */
public class RacingService {

    public void playGame(int playCount, Cars cars) {
        System.out.println(GameConstants.PLAY_RESULT);
        for (int i = 0; i < playCount; i++) {
            cars.move();
            cars.printCars();
        }

        System.out.println(cars.getWinners() + GameConstants.WINNER);
    }

}
