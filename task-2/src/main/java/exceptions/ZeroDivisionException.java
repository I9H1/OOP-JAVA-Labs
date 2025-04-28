package exceptions;

public class ZeroDivisionException extends CalculatorException {
    public ZeroDivisionException() {
        super("Zero division");
    }
}
