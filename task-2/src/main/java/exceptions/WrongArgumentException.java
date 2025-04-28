package exceptions;

public class WrongArgumentException extends CalculatorException {
    public WrongArgumentException(String commandName, String argument) {
        super(String.format("Wrong argument of command %s: %s", commandName, argument));
    }
}
