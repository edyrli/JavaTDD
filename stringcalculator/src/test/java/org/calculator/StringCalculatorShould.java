package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorShould {
    @Test
    public void Return1GivenString1(){
        //Arrange
        StringCalculator calculator = new StringCalculator();

        //Act
        int expectedResult = calculator.Add("1");

        //Assert
        assertEquals(1, expectedResult);
    }
}
