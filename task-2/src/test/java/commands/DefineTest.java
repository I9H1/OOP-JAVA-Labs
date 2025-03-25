package commands;

import exceptions.WrongArgumentException;
import exceptions.WrongArgumentsAmount;
import main.ExecContext;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {
    @Test
    void testDefine1() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("a");
        args.add("5.0");
        Command cmd = new Define();
        assertDoesNotThrow(() -> {
            cmd.execute(context, args);
        });
        assertEquals(5, context.getVar("a"));
    }

    @Test
    void testDefine2() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("a");
        args.add("b");
        Command cmd = new Define();
        assertThrows(WrongArgumentException.class, () -> {
            cmd.execute(context, args);
        });
    }

    @Test
    void testDefine3() {
        ExecContext context = new ExecContext();
        LinkedList<String> args = new LinkedList<>();
        args.add("");
        Command cmd = new Define();
        assertThrows(WrongArgumentsAmount.class, () -> {
            cmd.execute(context, args);
        });
    }
}