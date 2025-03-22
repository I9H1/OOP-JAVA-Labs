package commands;

import exceptions.CalculatorException;
import exceptions.WrongArgumentsAmount;
import exceptions.WrongArgumentException;
import main.ExecContext;

public class Define extends Command {
    @Override
    public void execute(ExecContext context, String[] args) throws CalculatorException {
        if (args.length != 2) {
            throw new WrongArgumentsAmount(getName(), 2, args.length);
        }
        try {
            context.vars.put(args[0], Double.parseDouble(args[1]));
        } catch (NumberFormatException e) {
            throw new WrongArgumentException(getName(), args[1]);
        }
    }

    @Override
    public String getName() {
        return "DEFINE";
    }
}
