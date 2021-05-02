package com.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jaedoo Lee
 */
class CarsTest {

    private static final String carName = "car";
    RandomEngine engine = new RandomEngine();
    List<Car> carList;
    Cars cars;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
    }

    @ParameterizedTest
    @CsvSource("3, 2; 4; 3; 9;")
    @DisplayName("Winner 개수가 1개")
    void 결과_테스트1(String winnerCarIdx, @ConvertWith(StringArrayConverter.class) String[] position) {
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(carName + i, Integer.parseInt(position[i]), engine);
            carList.add(car);
        }
        cars = new Cars(carList);
        assertEquals(cars.getWinners(), carName + winnerCarIdx);

    }

    @ParameterizedTest
    @CsvSource("0, 9; 2; 3; 0;")
    @DisplayName("Winner 개수가 1개")
    void 결과_테스트2(String winnerCarIdx, @ConvertWith(StringArrayConverter.class) String[] position) {
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(carName + i, Integer.parseInt(position[i]), engine);
            carList.add(car);
        }
        cars = new Cars(carList);
        assertEquals(cars.getWinners(), carName + winnerCarIdx);

    }

    @ParameterizedTest
    @CsvSource("1; 3, 1; 9; 5; 9;")
    @DisplayName("Winner 개수가 2개")
    void 결과_테스트3(@ConvertWith(StringArrayConverter.class) String[] winners, @ConvertWith(StringArrayConverter.class) String[] position) {
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(carName + i, Integer.parseInt(position[i]), engine);
            carList.add(car);
        }
        cars = new Cars(carList);
        assertEquals(cars.getWinners(), getWinnerCarName(winners));

    }

    @ParameterizedTest
    @CsvSource("0; 1; 3, 9; 9; 5; 9;")
    @DisplayName("Winner 개수가 3개")
    void 결과_테스트4(@ConvertWith(StringArrayConverter.class) String[] winners, @ConvertWith(StringArrayConverter.class) String[] position) {
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(carName + i, Integer.parseInt(position[i]), engine);
            carList.add(car);
        }
        cars = new Cars(carList);
        assertEquals(cars.getWinners(), getWinnerCarName(winners));

    }

    @ParameterizedTest
    @CsvSource("0; 1; 2; 3, 9; 9; 9; 9;")
    @DisplayName("Winner 개수가 4개")
    void 결과_테스트5(@ConvertWith(StringArrayConverter.class) String[] winners, @ConvertWith(StringArrayConverter.class) String[] position) {
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(carName + i, Integer.parseInt(position[i]), engine);
            carList.add(car);
        }
        cars = new Cars(carList);
        assertEquals(cars.getWinners(), getWinnerCarName(winners));

    }

    @ParameterizedTest
    @CsvSource("0; 1; 2; 3, 0; 0; 0; 0;")
    @DisplayName("Winner 개수가 4개")
    void 결과_테스트6(@ConvertWith(StringArrayConverter.class) String[] winners, @ConvertWith(StringArrayConverter.class) String[] position) {
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(carName + i, Integer.parseInt(position[i]), engine);
            carList.add(car);
        }
        cars = new Cars(carList);
        assertEquals(cars.getWinners(), getWinnerCarName(winners));
    }

    private static String getWinnerCarName(String[] carNames) {
        StringBuilder sb = new StringBuilder();
        for (String name : carNames) {
            sb.append(carName).append(name).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    // 값로 배열 값 구분
    public static class StringArrayConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            if (source instanceof String && String[].class.isAssignableFrom(targetType)) {
                return ((String) source).split("\\s*;\\s*");
            }
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                                               + targetType + " not supported.");
        }

    }

}
