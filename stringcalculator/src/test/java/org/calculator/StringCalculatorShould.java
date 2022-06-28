package org.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorShould {
    private static Stream<Arguments> testParameters() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("2", 2),
                Arguments.of("1,2", 3)
        );
    }

    @Test
    public void Return1GivenString1() {
        //Arrange
        StringCalculator calculator = new StringCalculator();

        //Act
        int expectedResult = calculator.Add("1");

        //Assert
        assertEquals(1, expectedResult);
    }

    @Test
    public void Return2GivenString2() {
        //Arrange
        StringCalculator calculator = new StringCalculator();

        //Act
        int expectedResult = calculator.Add("2");

        //Assert
        assertEquals(2, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("testParameters")
    public void SumGivenNumbers(String inputString, int outputInt) {
        //Arrange
        StringCalculator calculator = new StringCalculator();

        //Act
        int expectedResult = calculator.Add(inputString);

        //Assert
        assertEquals(outputInt, expectedResult);
    }
}
