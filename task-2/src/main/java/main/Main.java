package main;

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

        // Creating reading stream
        BufferedReader reader;
        if (args.length > 0) {
            try (FileReader fileReader = new FileReader(args[0])) {
                reader = new BufferedReader(fileReader);
            } catch (IOException e) {
                System.out.println("Error while opening file: " + e.getMessage());
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading line: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error while closing file: " + e.getMessage());
            }
        }

    }
}