package command.commands;

import command.Console;

public class DivCommand implements UndoableCommand {
    private int input;
    private Console console;

    public DivCommand(int input, Console console) {
        this.input = input;
        this.console = console;
    }

    @Override
    public void execute() {
        int result = console.getState() / input;
        console.setState(result);
    }

    @Override
    public void undo() {
        int result = console.getState() * input;
        console.setState(result);
    }
}
