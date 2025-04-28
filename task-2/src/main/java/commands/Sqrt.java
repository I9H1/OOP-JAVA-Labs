package commands;

import exceptions.CalculatorException;
import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;

import java.util.LinkedList;

public class Sqrt extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) throws CalculatorException {
        if (!args.isEmpty()) {
            throw new WrongArgumentsAmount(getName(), 0, args.size());
        }
        if (context.getStackSize() != 0) {
            double a = context.pop();
            context.push(Math.sqrt(a));
        } else {
            throw new StackErrorException(getName(), 1, context.getStackSize());
        }
    }

    @Override
    public String getName() {
        return "SQRT";
    }
}
