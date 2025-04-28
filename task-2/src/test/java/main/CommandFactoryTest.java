package main;

import commands.Command;
import exceptions.CalculatorException;
import exceptions.CommandNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandFactoryTest {
    @Test
    void testCreateFactory() {
        assertDoesNotThrow(() -> {
            new CommandFactory();
        });
    }

    @Test
    void testCreateCommand1() {
        CommandFactory commandFactory = null;
        try {
            commandFactory = new CommandFactory();
        } catch (CalculatorException e) {}
        CommandFactory finalCommandFactory = commandFactory;
        assertDoesNotThrow(() -> {
            finalCommandFactory.createCommand("PUSH");
        });
    }

    @Test
    void testCreateCommand2() {
        CommandFactory commandFactory = null;
        try {
            commandFactory = new CommandFactory();
        } catch (CalculatorException e) {}
        CommandFactory finalCommandFactory = commandFactory;
        assertThrows(CommandNameException.class, () -> {
            finalCommandFactory.createCommand("PLUS");
        });
    }
}