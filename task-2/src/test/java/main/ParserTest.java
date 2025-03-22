package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Test
    void getNameTest() {
        Parser parser = new Parser();
        String line = "Name arg1 arg2 arg3";
        assertEquals("Name", parser.getName(line));
    }

    @Test
    void getArgsTest() {
        Parser parser = new Parser();
        String line = "Name arg1 arg2 arg3";
        assertEquals("arg1", parser.getArguments(line)[0]);
        assertEquals("arg2", parser.getArguments(line)[1]);
        assertEquals("arg3", parser.getArguments(line)[2]);
        assertEquals(3, parser.getArguments(line).length);
    }
}
