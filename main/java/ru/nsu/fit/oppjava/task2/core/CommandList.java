package ru.nsu.fit.oppjava.task2.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandList {
    private static Logger log = LoggerFactory.getLogger(CommandList.class);

    private Map<String, Class<?>> map;
    Properties properties;

    public CommandList(String resource) {
        map = new HashMap<>();
        try {
            InputStream inputStream = CommandList.class.getResourceAsStream(resource);
            properties = new Properties();
            properties.load(inputStream);
            for (String name :
                    properties.stringPropertyNames()) {
                if (!map.containsKey(name)) {
                    map.put(name, Class.forName(properties.getProperty(name)));
                    //.getDeclaredConstructor().newInstance());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            log.error("Caught exception in CommandList constructor:", e);
        }
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public Command get(String key, ExecutionContext context, String[] arguments) throws CommandListException {
        Command command;
        try {
            command = (Command) map.get(key).getDeclaredConstructor(ExecutionContext.class, String[].class).newInstance(context, arguments);
        } catch (NoSuchMethodException | IllegalAccessException |
                InvocationTargetException | InstantiationException ex) {
            throw new CommandListException(key, ex);
        }
        return command;
    }
}
