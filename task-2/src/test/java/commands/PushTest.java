package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {
    @Test
    void testPush1() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {"5.0"};
        Command cmd = new Push();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(5, context.stack.peek());
    }

    @Test
    void testPush2() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {"a"};
        Command cmd = new Push();
        assertThrows(WrongArgumentException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPush3() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        Command cmd = new Push();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPush4() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        context.vars.put("num1", 100.0);
        String[] args = {"num1"};
        Command cmd = new Push();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(100, context.stack.peek());
    }
}