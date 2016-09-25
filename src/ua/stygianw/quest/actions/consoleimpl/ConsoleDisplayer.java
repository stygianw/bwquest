package ua.stygianw.quest.actions.consoleimpl;

/**
 * Created by User on 25.09.2016.
 */
class ConsoleDisplayer implements MessageDisplayer {
    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void holdConsole(String message) {
        ConsoleUtils.holdConsole(message);
    }
}
