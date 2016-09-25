package ua.stygianw.quest.actions.consoleimpl;

import java.io.IOException;

/**
 * Created by User on 25.09.2016.
 */
class ConsoleUtils {

    public static void holdConsole(String message) {
        System.out.println(message);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
