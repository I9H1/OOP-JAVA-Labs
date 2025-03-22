package commands;

import exceptions.CalculatorException;
import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;

public class Print extends Command {
    @Override
    public void execute(ExecContext context, String[] args) throws CalculatorException {
        if (context.stack.empty()) {
            throw new StackErrorException(getName(), 1, 0);
        }
        if (args.length != 0) {
            throw new WrongArgumentsAmount(getName(), 0, args.length);
        }
        System.out.println(context.stack.peek());
    }

    @Override
    public String getName() {
        return "PRINT";
    }
}
