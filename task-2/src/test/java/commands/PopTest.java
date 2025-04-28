package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    @Test
    void testPop1() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        context.push(1.0);
        context.push(2.0);
        Command cmd = new Pop();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(1, context.peek());
    }

    @Test
    void testPop2() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        Command cmd = new Pop();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPop3() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("");
        context.push(1.0);
        Command cmd = new Pop();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}