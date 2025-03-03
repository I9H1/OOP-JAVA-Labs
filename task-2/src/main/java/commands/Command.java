package commands;

import main.ExecContext;

public abstract class Command {
    public abstract void execute(ExecContext context);
}
