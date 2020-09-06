package ru.nsu.fit.oppjava.task2.core;

public interface Command {

    String getName();

    void execute() throws CalculatorException;
}
