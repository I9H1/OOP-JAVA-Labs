package commands;

import exceptions.CalculatorException;
import main.ExecContext;

public abstract class Command {
    public abstract void execute(ExecContext context, String[] args) throws CalculatorException;
    public abstract String getName();
}
