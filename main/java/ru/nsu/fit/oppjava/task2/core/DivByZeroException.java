package ru.nsu.fit.oppjava.task2.core;

public class DivByZeroException extends CalculatorException {
    @Override
    public String getMyMessage() {
        return "Division by zero!";
    }
}
