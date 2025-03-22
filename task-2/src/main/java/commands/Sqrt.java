package commands;

import exceptions.CalculatorException;
import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;

public class Sqrt extends Command {
    @Override
    public void execute(ExecContext context, String[] args) throws CalculatorException {
        if (args.length != 0) {
            throw new WrongArgumentsAmount(getName(), 0, args.length);
        }
        if (!context.stack.isEmpty()) {
            double a = context.stack.pop();
            context.stack.push(Math.sqrt(a));
        } else {
            throw new StackErrorException(getName(), 1, context.stack.size());
        }
    }

    @Override
    public String getName() {
        return "SQRT";
    }
}
