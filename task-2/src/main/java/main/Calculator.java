package main;

import commands.Command;
import exceptions.CalculatorException;

import java.io.*;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    public static void main(String[] args) {
        // Initiating resources
        Logger logger = LoggerFactory.getLogger(Calculator.class);
        logger.info("Starting execution");
        Parser parser = new Parser();
        ExecContext context = new ExecContext();
        CommandFactory commandFactory;
        try {
            commandFactory = new CommandFactory();
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
            return;
        }

        // Creating input stream
        BufferedReader reader;
        if (args.length > 0) {
            try {
                FileReader fileReader = new FileReader(args[0]);
                reader = new BufferedReader(fileReader);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                logger.error(e.getMessage());
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        // Reading and executing commands
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                logger.info(line);
                CommandContext commandContext = parser.parse(line);
                String name = commandContext.name();
                LinkedList<String> arguments = commandContext.args();
                try {
                    Command command = commandFactory.createCommand(name);
                    command.execute(context, arguments);
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                    logger.error(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
        }

        // Closing input stream
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
        }
    }
}