package main;

import java.util.LinkedList;

public class CommandContext {
    private String name;
    private LinkedList<String> args;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getArgs() {
        return args;
    }

    public void setArgs(LinkedList<String> args) {
        this.args = args;
    }
}
