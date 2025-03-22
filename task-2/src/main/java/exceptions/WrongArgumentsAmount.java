package exceptions;

public class WrongArgumentsAmount extends CalculatorException {
    public WrongArgumentsAmount(String commandName, int expected, int actual) {
        super(String.format("Command %s requires %d arguments, but got %d", commandName, expected, actual));
    }
}
