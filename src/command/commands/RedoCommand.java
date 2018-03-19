package command.commands;

import command.CommandHistory;
import command.Console;

public class RedoCommand implements Command{
    private CommandHistory commandHistory;
    private Console console;

    public RedoCommand(CommandHistory commandHistory, Console console) {
        this.commandHistory = commandHistory;
        this.console = console;
    }

    @Override
    public void execute() {
        if (commandHistory.redoUndoPointerNotAtEnd()) {
            commandHistory.addHistory();
            commandHistory.getLastCommand().execute();
        } else {
            console.writeError("At the end of history!");
        }
    }
}
