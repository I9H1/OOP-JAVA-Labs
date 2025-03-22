package main;

import commands.Command;
import exceptions.CalculatorException;
import exceptions.CommandNameException;
import exceptions.FileNameException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandFactory {

    private static Properties properties;

    public CommandFactory() throws CalculatorException {
        properties = new Properties();
        String configFileName = "command_config.properties";
        InputStream stream = CommandFactory.class.getResourceAsStream(configFileName);
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new FileNameException(configFileName);
        }
    }

    public Command createCommand(String name) throws CalculatorException {
        Command command;
        String className = properties.getProperty(name);
        if (className != null) {
            try {
                Class<?> newClass = Class.forName(className);
                Object newObject = newClass.getConstructor().newInstance();
                command = (Command) newObject;
            } catch (Exception e) {
                throw new CommandNameException(name);
            }
        } else {
            throw new CommandNameException(name);
        }
        return command;
    }
}
