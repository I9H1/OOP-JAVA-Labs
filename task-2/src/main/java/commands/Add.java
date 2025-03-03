package commands;

import main.ExecContext;

public class Add extends Command {
    @Override
    public void execute(ExecContext context) {
        if (context.stack.size() >= 2) {
            double b = context.stack.pop();
            double a = context.stack.pop();
            context.stack.push(a + b);
        }
    }
}
