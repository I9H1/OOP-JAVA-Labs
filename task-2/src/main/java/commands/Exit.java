package commands;

import exceptions.CalculatorException;
import main.ExecContext;

public class Exit extends Command {
    @Override
    public void execute(ExecContext context, String[] args) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "EXIT";
    }
}
