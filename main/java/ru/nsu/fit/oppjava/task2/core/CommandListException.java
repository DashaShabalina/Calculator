package ru.nsu.fit.oppjava.task2.core;

public class CommandListException extends CalculatorException {
    private String message;

    public CommandListException(String command, Exception ex) {
        this.message = "Can't create command: " + command + ", exception: " + ex.getLocalizedMessage();
    }

    @Override
    String getMyMessage() {
        return message;
    }
}
