package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenLevelFunctionThenLevelResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(0, 3, x -> Math.pow(3, x) + 2);
        List<Double> expected = Arrays.asList(3D, 5D, 11D);
        assertThat(result).containsAll(expected);
    }
}