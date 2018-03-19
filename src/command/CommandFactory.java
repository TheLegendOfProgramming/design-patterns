package command;

import command.commands.*;

public class CommandFactory {
    private Console console;
    private CommandHistory commandHistory;

    public CommandFactory(Console console, CommandHistory commandHistory) {
        this.console = console;
        this.commandHistory = commandHistory;
    }

    public UndoableCommand createUnduableCommand(String commandName, int input) throws Exception {
        switch (commandName) {
            case "add":
                return new AddCommand(input, console);
            case "sub":
                return new SubCommand(input, console);
            case "div":
                return new DivCommand(input, console);
            case "times":
                return new TimesCommand(input, console);
        }
        throw new Exception("Unknown command "+commandName);
    }

    public Command createCommand(String commandName) throws Exception {
        switch (commandName) {
            case "redo":
                return new RedoCommand(commandHistory, console);
            case "undo":
                return new UndoCommand(commandHistory, console);
        }
        throw new Exception("Unknown command "+commandName);
    }
}
