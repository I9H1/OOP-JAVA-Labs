package commands;

import main.ExecContext;

import java.util.LinkedList;

public class Comment extends Command {
    @Override
    public void execute(ExecContext context, LinkedList<String> args) {}

    @Override
    public String getName() {
        return "COMMENT";
    }
}
