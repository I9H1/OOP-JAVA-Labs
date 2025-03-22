package main;

public class Parser {
    public String getName(String line) {
        return line.split(" ")[0];
    }

    public String[] getArguments(String line) {
        String[] tokens = line.split(" ");
        String[] arguments = new String[tokens.length - 1];
        System.arraycopy(tokens, 1, arguments, 0, tokens.length - 1);
        return arguments;
    }
}
