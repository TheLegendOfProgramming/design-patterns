package command;

import command.commands.UndoableCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<UndoableCommand> commandHistory = new ArrayList<>();
    private int redoUndoPointer = -1;

    public UndoableCommand addCommand(UndoableCommand command) {
        commandHistory.add(command);
        if (redoUndoPointerAlignedWithHistory()) {
            redoUndoPointer++;
        }
        return command;
    }

    private boolean redoUndoPointerAlignedWithHistory() {
        return redoUndoPointer == commandHistory.size() - 1 - 1;
    }

    public boolean redoUndoPointerAtStart() {
        return redoUndoPointer == -1;
    }

    public boolean redoUndoPointerNotAtEnd() {
        return redoUndoPointer != commandHistory.size()-1;
    }

    public UndoableCommand getLastCommand() {
        return commandHistory.get(redoUndoPointer);
    }

    public void subHistory() {
        redoUndoPointer--;
    }

    public void addHistory() {
        redoUndoPointer++;
    }
}
