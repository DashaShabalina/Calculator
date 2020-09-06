package ru.nsu.fit.oppjava.task2.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.Reader;

public class Calculator {
    private static Logger log = LoggerFactory.getLogger(Calculator.class);

    private PrintWriter writer;
    private Reader reader;
    private String resource;

    public Calculator(Reader reader, PrintWriter writer, String resource) {
        this.reader = reader;
        this.writer = writer;
        this.resource = resource;
    }

    public void run() {
        Command command;
        log.info("Try to create CommandProvider");
        CommandProvider provider = new CommandProvider(reader, writer, resource);
        while ((command = provider.getCommand()) != null) {
            try {
                command.execute();
            } catch (DivByZeroException | MyEmptyStackException ex) {
                log.error("Error in command \"" + command.getName() + "\": " + ex.getMyMessage());
                return;
            } catch (CalculatorException ex) {
                log.error("Error in command \"" + command.getName() + "\": " + ex.getMyMessage());
            }
        }
    }
}
