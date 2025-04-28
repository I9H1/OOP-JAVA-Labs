package commands;

import exceptions.CalculatorException;
import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;

import java.util.LinkedList;

public class Add extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) throws CalculatorException {
        if (!args.isEmpty()) {
            throw new WrongArgumentsAmount(getName(), 0, args.size());
        }
        if (context.getStackSize() >= 2) {
            double b = context.pop();
            double a = context.pop();
            context.push(a + b);
        } else {
            throw new StackErrorException(getName(), 2, context.getStackSize());
        }
    }

    @Override
    public String getName() {
        return "+";
    }
}
