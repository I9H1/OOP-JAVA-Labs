package main;

import java.util.LinkedList;

public record CommandContext(String name, LinkedList<String> args) {}
