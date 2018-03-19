package command.commands;

import command.Console;

public class AddCommand implements UndoableCommand {
    private int input;
    private Console console;

    public AddCommand(int input, Console console) {
        this.input = input;
        this.console = console;
    }

    @Override
    public void execute() {
        int result = console.getState() + input;
        console.setState(result);
    }

    @Override
    public void undo() {
        int result = console.getState() - input;
        console.setState(result);
    }
}
