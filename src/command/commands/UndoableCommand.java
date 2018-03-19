package command.commands;

public interface UndoableCommand extends Command {
    void undo();
}
