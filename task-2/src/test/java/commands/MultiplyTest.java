package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {
    @Test
    void testMultiply1() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        context.push(2.0);
        context.push(50.0);
        Command cmd = new Multiply();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(100, context.peek());
    }

    @Test
    void testMultiply2() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        context.push(1.0);
        Command cmd = new Multiply();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testMultiply3() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("");
        context.push(1.0);
        context.push(99.0);
        Command cmd = new Multiply();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}