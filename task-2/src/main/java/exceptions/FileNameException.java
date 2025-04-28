package exceptions;

public class FileNameException extends CalculatorException {
    public FileNameException(String filename) {
        super(String.format("No such file: %s", filename));
    }
}
