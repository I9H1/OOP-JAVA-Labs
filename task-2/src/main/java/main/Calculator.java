package main;

import commands.Command;
import exceptions.CalculatorException;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        // Initiating resources
        Parser parser = new Parser();
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        CommandFactory commandFactory;
        try {
            commandFactory = new CommandFactory();
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
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
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        // Reading and executing commands
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String name = parser.getName(line);
                String[] arguments = parser.getArguments(line);
                try {
                    Command command = commandFactory.createCommand(name);
                    command.execute(context, arguments);
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Closing input stream
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}