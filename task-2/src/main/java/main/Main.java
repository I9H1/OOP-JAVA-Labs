package main;

import commands.Command;
import commands.CommandFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        CommandFactory commandFactory = new CommandFactory();

        BufferedReader reader = null;
        try {
            if (args.length > 0) {
                FileReader fileReader = new FileReader(args[0]);
                reader = new BufferedReader(fileReader);
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String name = line.split(" ")[0];
                String arguments = line.split(" ")[1];
                Command command = commandFactory.createCommand(name);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error while closing resource: " + e.getMessage());
                }
            }
        }
    }

    public void parse(String[] arguments, String name) {
        
    }

}