package ru.nsu.fit.oppjava.task2.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class CommandProvider {
    private static Logger log = LoggerFactory.getLogger(CommandProvider.class);

    private Scanner scanner;
    private ExecutionContext context;
    CommandList commandList;

    public CommandProvider(Reader reader, PrintWriter writer, String resource) {
        scanner = new Scanner(reader);
        context = new ExecutionContext(writer);
        commandList = new CommandList(resource);
        log.info("CommandProvider was created");
    }

    public Command getCommand() {
        String[] args;
        try {
            while (true) {
                try {
                    if (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        log.info("Got command: " + line);
                        args = line.split(" ");
                        if (args.length == 0) {
                            throw new IllegalCommandException(line);
                        }
                        if (!commandList.containsKey(args[0])) {
                            throw new IllegalCommandException(args[0]);
                        }
                        return commandList.get(args[0], context, args);
                    } else {
                        return null;
                    }
                } catch (IllegalCommandException ex) {
                    log.error(ex.getMyMessage());
                }
            }
        } catch (CommandListException cl){
            log.error(cl.getMyMessage());
            return null;
        }

    }
}
