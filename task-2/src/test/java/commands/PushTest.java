package commands;

import exceptions.WrongArgumentException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {
    @Test
    void testPush1() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("5.0");
        Command cmd = new Push();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(5, context.peek());
    }

    @Test
    void testPush2() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("a");
        Command cmd = new Push();
        assertThrows(WrongArgumentException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPush3() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        Command cmd = new Push();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPush4() {
        ExecContext context = new ExecContext();
        context.addVar("num1", 100.0);
        LinkedList<String> args = new LinkedList<>();
        args.add("num1");
        Command cmd = new Push();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(100, context.peek());
    }
}