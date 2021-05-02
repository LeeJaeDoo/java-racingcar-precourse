package com.study.presentation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaedoo Lee
 */
class GameInputRequestTest {

    @Test
    void 자동차_이름_길이_5_초과시_retry() {
        String[] carNames = {"hello1", "h2"};
        GameInputRequest request = new GameInputRequest(3, carNames);
        assertTrue(request.isRetry());
    }

    @Test
    void 자동차_이름_길이_5_미만시() {
        String[] carNames = {"h1", "h2"};
        GameInputRequest request = new GameInputRequest(3, carNames);
        assertFalse(request.isRetry());
    }


}
