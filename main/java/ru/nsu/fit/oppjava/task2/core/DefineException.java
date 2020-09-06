package ru.nsu.fit.oppjava.task2.core;

public class DefineException extends CalculatorException {
    String message = "";

    public DefineException(String[] args) {
        for (String str :
                args) {
            message += str + " ";
        }
    }

    @Override
    public String getMyMessage() {
        return "Incorrect define string: " + message;
    }
}
