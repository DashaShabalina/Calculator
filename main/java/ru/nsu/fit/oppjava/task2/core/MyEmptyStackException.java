package ru.nsu.fit.oppjava.task2.core;

public class MyEmptyStackException extends CalculatorException {
    @Override
    public String getMyMessage() {
        return "Empty stack";
    }
}
