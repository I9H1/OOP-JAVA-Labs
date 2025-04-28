package exceptions;

public class CommandNameException extends CalculatorException {
    public CommandNameException(String commandName) {
        super(String.format("No such command: %s", commandName));
    }
}
