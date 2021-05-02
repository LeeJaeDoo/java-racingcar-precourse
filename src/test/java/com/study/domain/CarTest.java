package com.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaedoo Lee
 */
class CarTest {

    RandomEngine engine = new RandomEngine();
    List<Car> carList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 5; i++) {
            Car car = new Car("car" + i, new Random().nextInt(9), engine);
            carList.add(car);
        }
    }

    @Test
    void 자동차_위치_내림차순_정렬_테스트() {
        Collections.sort(carList);
        for (int i = 1; i < carList.size(); i++) {
            assertTrue(carList.get(i - 1).getPosition() >= carList.get(i).getPosition());
        }
    }

}
