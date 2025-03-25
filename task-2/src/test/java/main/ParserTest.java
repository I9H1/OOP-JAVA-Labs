package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void getNameTest() {
        Parser parser = new Parser();
        String line = "Name arg1 arg2 arg3";
        CommandContext context = parser.parse(line);
        assertEquals("Name", context.getName());
    }

    @Test
    void getArgsTest() {
        Parser parser = new Parser();
        String line = "Name arg1 arg2 arg3";
        CommandContext context = parser.parse(line);
        assertEquals("arg1", context.getArgs().get(0));
        assertEquals("arg2", context.getArgs().get(1));
        assertEquals("arg3", context.getArgs().get(2));
        assertEquals(3, context.getArgs().size());
    }
}
