package commands;

import main.ExecContext;

public class Comment extends Command {
    @Override
    public void execute(ExecContext context, String[] args) {}

    @Override
    public String getName() {
        return "COMMENT";
    }
}
