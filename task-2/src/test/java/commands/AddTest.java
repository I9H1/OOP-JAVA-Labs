package commands;


import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    @Test
    void testAdd1() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        context.stack.push(1.0);
        context.stack.push(99.0);
        Command cmd = new Add();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(100, context.stack.peek());
    }

    @Test
    void testAdd2() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        context.stack.push(1.0);
        Command cmd = new Add();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testAdd3() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {""};
        context.stack.push(1.0);
        context.stack.push(99.0);
        Command cmd = new Add();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}