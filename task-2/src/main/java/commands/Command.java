package commands;

import exceptions.CalculatorException;
import main.ExecContext;

import java.util.LinkedList;

public abstract class Command {
    public abstract void execute(ExecContext context, LinkedList<String> args) throws CalculatorException;
    public abstract String getName();
}
