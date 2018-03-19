package command;

import command.commands.Command;
import command.commands.UndoableCommand;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Console console = new Console();
        CommandHistory commandHistory = new CommandHistory();
        CommandFactory commandFactory = new CommandFactory(console, commandHistory);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String rawInput = scanner.nextLine();
                if (rawInput.equals("exit")) {
                    System.out.println("Bye, bye.");
                    return;
                }
                String[] splitInput = rawInput.split(" ");
                if (splitInput.length == 2) {
                    int parameter = Integer.parseInt(splitInput[1]);
                    UndoableCommand command = commandFactory.createUnduableCommand(splitInput[0], parameter);
                    command.execute();
                    commandHistory.addCommand(command);
                } else if (splitInput.length == 1) {
                    Command command = commandFactory.createCommand(splitInput[0]);
                    command.execute();
                }
            } catch (Exception e) {
                console.writeError("unknown command");
            }
        }
    }
}
