package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    @Test
    void testPrint1() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        context.push(1.0);
        Command cmd = new Print();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPrint2() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        Command cmd = new Print();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPrint3() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("");
        context.push(1.0);
        Command cmd = new Print();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}