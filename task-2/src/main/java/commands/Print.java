package commands;

import exceptions.CalculatorException;
import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;

import java.util.LinkedList;

public class Print extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) throws CalculatorException {
        if (context.getStackSize() == 0) {
            throw new StackErrorException(getName(), 1, 0);
        }
        if (!args.isEmpty()) {
            throw new WrongArgumentsAmount(getName(), 0, args.size());
        }
        System.out.println(context.peek());
    }

    @Override
    public String getName() {
        return "PRINT";
    }
}
