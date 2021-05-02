package com.study.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaedoo Lee
 */
public class Cars implements Moving {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void setCarList(String[] carNames) {
        RandomEngine engine = new RandomEngine();
        for (String carName : carNames) {
            Car car = new Car(carName, 0, engine);
            carList.add(car);
        }
    }

    @Override
    public void move() {
        for (Car car : carList) {
            car.move();
        }
    }

    public void printCars() {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + showMoveRange(car.getPosition()));
        }
        System.out.println();
    }

    public String getWinners() {
        Collections.sort(carList);
        int idx = 0;
        int max = carList.get(idx).getPosition();
        StringBuilder sb = new StringBuilder();
        while (idx < carList.size() && max == carList.get(idx).getPosition()) {
            sb.append(carList.get(idx).getName()).append(", ");
            idx++;
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String showMoveRange(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
