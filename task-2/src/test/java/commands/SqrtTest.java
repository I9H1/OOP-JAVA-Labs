package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    @Test
    void testSqrt1() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        context.stack.push(100.0);
        Command cmd = new Sqrt();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(10, context.stack.peek());
    }

    @Test
    void testSqrt2() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        Command cmd = new Sqrt();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testSqrt3() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {""};
        context.stack.push(1.0);
        Command cmd = new Sqrt();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}