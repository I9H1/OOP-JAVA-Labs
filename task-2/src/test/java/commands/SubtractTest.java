package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {
    @Test
    void testSubtract1() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        context.push(102.0);
        context.push(2.0);
        Command cmd = new Subtract();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(100, context.peek());
    }

    @Test
    void testSubtract2() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        context.push(1.0);
        Command cmd = new Subtract();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testSubtract3() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("");
        context.push(1.0);
        context.push(99.0);
        Command cmd = new Subtract();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}