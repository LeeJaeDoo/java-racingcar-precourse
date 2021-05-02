package com.study.presentation;

import com.study.domain.GameConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jaedoo Lee
 */
public class GameInputRequest {
    private final BufferedReader br;
    private int playCount;
    private String[] carNames;

    public GameInputRequest() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public GameInputRequest(int playCount, String[] carNames) {
        this();
        this.playCount = playCount;
        this.carNames = carNames;
    }

    public int getPlayCount() throws IOException {
        try {
            System.out.println(GameConstants.PLAY_COUNT);
            this.playCount = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            getPlayCount();
        }
        return this.playCount;
    }

    public String[] getCarList() throws IOException {
        this.carNames = br.readLine().split(",");
        return this.carNames;
    }

    public boolean isRetry() {
        for (String car : this.carNames) {
            return checkCarNameLength(car.length());
        }

        return false;
    }

    private boolean checkCarNameLength(int length) {
        return length > 5;
    }
}
