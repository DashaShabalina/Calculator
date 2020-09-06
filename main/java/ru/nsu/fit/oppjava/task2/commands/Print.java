package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.*;

import java.io.PrintWriter;
import java.util.EmptyStackException;

public class Print implements Command {
    ExecutionContext context;
    PrintWriter writer;

    public Print(ExecutionContext context, String[] arguments) {
        this.context = context;
        this.writer = context.getWriter();
    }

    @Override
    public String getName() {
        return "PRINT";
    }

    @Override
    public void execute() throws CalculatorException {
        try {
            double val = context.stackPeek();
            writer.println(val);
            writer.flush();
        } catch (EmptyStackException es) {
            throw new MyEmptyStackException();
        }
    }
}
