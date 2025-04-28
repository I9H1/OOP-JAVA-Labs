package commands;

import exceptions.CalculatorException;
import exceptions.WrongArgumentsAmount;
import exceptions.WrongArgumentException;
import main.ExecContext;

import java.util.LinkedList;

public class Push extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) throws CalculatorException {
        if (args.size() != 1) {
            throw new WrongArgumentsAmount(getName(), 1, args.size());
        }
        try {
            if (context.containsVar(args.get(0))) {
                context.push(context.getVar(args.get(0)));
            } else {
                context.push(Double.parseDouble(args.get(0)));
            }
        } catch (NumberFormatException e) {
            throw new WrongArgumentException(getName(), args.get(0));
        }
    }

    @Override
    public String getName() {
        return "PUSH";
    }
}
