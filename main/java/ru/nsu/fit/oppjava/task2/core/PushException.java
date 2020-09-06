package ru.nsu.fit.oppjava.task2.core;

public class PushException extends CalculatorException {
    String message = "";

    public PushException(String[] args) {
        for (String str :
                args) {
            message += str + " ";
        }
    }

    @Override
    public String getMyMessage() {
        return "Incorrect push string: " + message;
    }
}
