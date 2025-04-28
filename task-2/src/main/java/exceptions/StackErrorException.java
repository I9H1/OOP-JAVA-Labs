package exceptions;

public class StackErrorException extends CalculatorException {
    public StackErrorException(String commandName, int requiredSize, int actualSize) {
        super(String.format("Command %s requires stack size %d, got %d", commandName, requiredSize, actualSize));
    }
}
