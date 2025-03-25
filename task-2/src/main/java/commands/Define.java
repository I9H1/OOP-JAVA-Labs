package commands;

import exceptions.CalculatorException;
import exceptions.WrongArgumentsAmount;
import exceptions.WrongArgumentException;
import main.ExecContext;

import java.util.LinkedList;

public class Define extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) throws CalculatorException {
        if (args.size() != 2) {
            throw new WrongArgumentsAmount(getName(), 2, args.size());
        }
        try {
            context.addVar(args.get(0), Double.parseDouble(args.get(1)));
        } catch (NumberFormatException e) {
            throw new WrongArgumentException(getName(), args.get(1));
        }
    }

    @Override
    public String getName() {
        return "DEFINE";
    }
}
