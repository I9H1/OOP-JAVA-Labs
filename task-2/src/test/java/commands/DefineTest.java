package commands;

import exceptions.StackErrorException;
import exceptions.WrongArgumentException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {
    @Test
    void tesDefine1() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {"a", "5.0"};
        Command cmd = new Define();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(5, context.vars.get("a"));
    }

    @Test
    void testDefine2() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {"b", "string"};
        Command cmd = new Define();
        assertThrows(WrongArgumentException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testDefine3() {
        ExecContext context = new ExecContext();
        context.stack = new Stack<>();
        context.vars = new HashMap<>();
        String[] args = {""};
        Command cmd = new Define();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}