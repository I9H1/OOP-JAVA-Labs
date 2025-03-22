package commands;

import exceptions.CalculatorException;
import exceptions.WrongArgumentsAmount;
import exceptions.WrongArgumentException;
import main.ExecContext;

public class Push extends Command {
    @Override
    public void execute(ExecContext context, String[] args) throws CalculatorException {
        if (args.length != 1) {
            throw new WrongArgumentsAmount(getName(), 1, args.length);
        }
        try {
            if (context.vars.containsKey(args[0])) {
                context.stack.push(context.vars.get(args[0]));
            } else {
                context.stack.push(Double.parseDouble(args[0]));
            }
        } catch (NumberFormatException e) {
            throw new WrongArgumentException(getName(), args[0]);
        }
    }

    @Override
    public String getName() {
        return "PUSH";
    }
}
