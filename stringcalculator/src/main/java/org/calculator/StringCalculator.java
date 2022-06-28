package org.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StringCalculator {
    public int Add(String s) {
        List<String> listOfStrings = Arrays.asList(s.split(","));
        AtomicInteger result = new AtomicInteger();
        listOfStrings.forEach(number ->
                result.addAndGet(Integer.valueOf(number))
        );
        return result.get();
    }
}
