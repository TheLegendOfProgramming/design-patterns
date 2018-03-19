package command.commands;

import command.CommandHistory;
import command.Console;

public class UndoCommand implements Command{
    private CommandHistory commandHistory;
    private Console console;

    public UndoCommand(CommandHistory commandHistory, Console console) {
        this.commandHistory = commandHistory;
        this.console = console;
    }


    @Override
    public void execute() {
        if (!commandHistory.redoUndoPointerAtStart()) {
            commandHistory.getLastCommand().undo();
            commandHistory.subHistory();
        } else {
            console.writeError("No more steps to go back to");
        }
    }
}
