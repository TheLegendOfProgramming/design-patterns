package command.commands;

import command.Console;

public class SubCommand implements UndoableCommand {
    private int input;
    private Console console;

    public SubCommand(int input, Console console) {
        this.input = input;
        this.console = console;
    }

    @Override
    public void execute() {
        int result = console.getState() - input;
        console.setState(result);
    }

    @Override
    public void undo() {
        int result = console.getState() + input;
        console.setState(result);
    }
}
