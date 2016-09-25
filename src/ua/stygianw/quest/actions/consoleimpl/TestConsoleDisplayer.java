package ua.stygianw.quest.actions.consoleimpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25.09.2016.
 */
public class TestConsoleDisplayer implements MessageDisplayer {

    List<String> messages = new ArrayList<>();

    @Override
    public void display(String message) {
        messages.add(message);
    }

    @Override
    public void holdConsole(String message) {
        // Do nothing
    }

    public List<String> getMessages() {
        return messages;
    }
}
