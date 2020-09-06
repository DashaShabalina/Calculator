package ru.nsu.fit.oppjava.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.fit.oppjava.task2.core.Calculator;
import ru.nsu.fit.oppjava.task2.providers.ReaderProvider;
import ru.nsu.fit.oppjava.task2.providers.WriterProvider;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Program begins, try to get reader/writer");
        try (Reader reader = new ReaderProvider(args).get();
             PrintWriter writer = new WriterProvider(args).get()) {
            String resource = "/Resource.properties";
            log.info("Create calculator");
            Calculator calculator = new Calculator(reader, writer, resource);
            log.info("Run calculator");
            calculator.run();
            log.info("Calculator has completed work");
        } catch (IOException io) {
            log.error("Main error:", io);
        }
    }
}
