package ru.nsu.fit.oppjava.task2.providers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriterProvider {
    private PrintWriter writer;

    public WriterProvider(String[] args) throws IOException {
        if (args.length > 1) {
            writer = new PrintWriter(new FileWriter(args[1]));
        } else {
            writer = new PrintWriter(new OutputStreamWriter(System.out));
        }
    }

    public PrintWriter get() {
        return writer;
    }
}
