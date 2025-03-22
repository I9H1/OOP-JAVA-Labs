package commands;

import exceptions.CalculatorException;
import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;

public class Subtract extends Command {
    @Override
    public void execute(ExecContext context, String[] args) throws CalculatorException {
        if (args.length != 0) {
            throw new WrongArgumentsAmount(getName(), 0, args.length);
        }
        if (context.stack.size() >= 2) {
            double b = context.stack.pop();
            double a = context.stack.pop();
            context.stack.push(a - b);
        } else {
            throw new StackErrorException(getName(), 2, context.stack.size());
        }
    }

    @Override
    public String getName() {
        return "-";
    }
}
