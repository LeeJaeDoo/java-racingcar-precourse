package com.study.presentation;

import com.study.application.RacingService;
import com.study.domain.Cars;
import com.study.domain.GameConstants;

import java.io.IOException;

/**
 * @author Jaedoo Lee
 */
public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void play() throws IOException {
        GameInputRequest request = new GameInputRequest();
        Cars cars = null;

        do {
            System.out.println(GameConstants.INPUT_CAR_NAME);
            cars = new Cars();
            cars.setCarList(request.getCarList());
        } while (request.isRetry());

        racingService.playGame(request.getPlayCount(), cars);
    }

}
