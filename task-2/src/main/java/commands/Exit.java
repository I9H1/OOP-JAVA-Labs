package commands;

import exceptions.CalculatorException;
import main.ExecContext;

import java.util.LinkedList;

public class Exit extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "EXIT";
    }
}
