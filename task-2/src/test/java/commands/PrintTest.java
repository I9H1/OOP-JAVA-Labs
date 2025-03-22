package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    @Test
    void testPrint1() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        context.stack.push(1.0);
        Command cmd = new Print();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPrint2() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {};
        Command cmd = new Print();
        assertThrows(StackErrorException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testPrint3() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {""};
        context.stack.push(1.0);
        Command cmd = new Print();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}