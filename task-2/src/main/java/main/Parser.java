package main;

import java.util.Arrays;
import java.util.LinkedList;

public class Parser {
    public CommandContext parse(String line) {
        String name = line.split(" ")[0];
        String[] tokens = line.split(" ");
        LinkedList<String> arguments = new LinkedList<>(Arrays.asList(tokens).subList(1, tokens.length));
        return new CommandContext(name, arguments);
    }
}
