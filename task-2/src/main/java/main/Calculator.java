package main;

import commands.Command;
import exceptions.CalculatorException;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Calculator {
    public static void main(String[] args) {
        // Initiating resources
        Logger logger = Logger.getLogger(Calculator.class.getName());
        try {
            LogManager.getLogManager().readConfiguration
                    (Calculator.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        Parser parser = new Parser();
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        CommandFactory commandFactory;
        try {
            commandFactory = new CommandFactory();
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage());
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
                logger.log(Level.SEVERE, e.getMessage());
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        // Reading and executing commands
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                logger.log(Level.INFO, line);
                String name = parser.getName(line);
                String[] arguments = parser.getArguments(line);
                try {
                    Command command = commandFactory.createCommand(name);
                    command.execute(context, arguments);
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                    logger.log(Level.SEVERE, e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage());
        }

        // Closing input stream
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}