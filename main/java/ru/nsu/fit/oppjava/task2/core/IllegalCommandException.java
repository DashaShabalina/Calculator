package ru.nsu.fit.oppjava.task2.core;

public class IllegalCommandException extends CalculatorException {
    private String command;

    public IllegalCommandException(String string) {
        command = string;
    }

    @Override
    public String getMyMessage() {
        return "Illegal command: " + command;
    }
}
