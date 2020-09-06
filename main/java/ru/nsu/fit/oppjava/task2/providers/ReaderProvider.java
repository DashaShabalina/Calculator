package ru.nsu.fit.oppjava.task2.providers;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderProvider {
    private Reader reader;

    public ReaderProvider(String[] args) throws IOException {
        if (args.length > 0) {
            reader = new FileReader(args[0]);
        } else {
            reader = new InputStreamReader(System.in);
        }
    }

    public Reader get() {
        return reader;
    }
}
