package commands;

import exceptions.*;
import main.ExecContext;

public class Divide extends Command {
    @Override
    public void execute(ExecContext context, String[] args) throws CalculatorException {
        if (args.length != 0) {
            throw new WrongArgumentsAmount(getName(), 0, args.length);
        }
        if (context.stack.size() >= 2) {
            double b = context.stack.pop();
            if (b == 0) {
                context.stack.push(b);
                throw new ZeroDivisionException();
            }
            double a = context.stack.pop();
            context.stack.push(a / b);
        } else {
            throw new StackErrorException(getName(), 2, context.stack.size());
        }
    }

    @Override
    public String getName() {
        return "/";
    }
}
