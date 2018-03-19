package command;

import java.io.PrintStream;

public class Console {
    private PrintStream console = System.out;
    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        console.println(state);
    }

    public void writeError(String error) {
        console.println(error);
    }
}
