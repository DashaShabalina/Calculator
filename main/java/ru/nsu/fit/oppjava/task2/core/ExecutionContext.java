package ru.nsu.fit.oppjava.task2.core;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private Map<String, Double> define;
    private Stack<Double> stack;
    private PrintWriter writer;

    public ExecutionContext(PrintWriter writer) {
        this.writer = writer;
        define = new HashMap<>();
        stack = new Stack<>();
    }

    public Double stackPeek() {
        return stack.peek();
    }

    public Double stackPop() {
        return stack.pop();
    }

    public void stackPush(double item) {
        stack.push(item);
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public boolean defineContainsKey(String key) {
        return define.containsKey(key);
    }

    public void defineReplace(String key, Double value) {
        define.replace(key, value);
    }

    public void definePut(String key, Double value) {
        define.put(key, value);
    }

    public Double defineGet(String key) {
        return define.get(key);
    }
}
