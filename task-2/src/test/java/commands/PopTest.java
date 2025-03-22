package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    @Test
    void testPop1() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        context.stack.push(1.0);
        context.stack.push(2.0);
        Command cmd = new Pop();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(1, context.stack.peek());
    }

    @Test
    void testPop2() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        Command cmd = new Pop();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPop3() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {""};
        context.stack.push(1.0);
        Command cmd = new Pop();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}