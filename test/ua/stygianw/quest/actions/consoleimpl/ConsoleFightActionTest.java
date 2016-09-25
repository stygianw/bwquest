package ua.stygianw.quest.actions.consoleimpl;

import org.junit.Before;
import org.junit.Test;
import ua.stygianw.quest.actions.FightActionOutcome;
import ua.stygianw.quest.player.Enemy;
import ua.stygianw.quest.player.Player;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 25.09.2016.
 */
public class ConsoleFightActionTest {

    ConsoleFightAction action;

    @Before
    public void setUp() throws Exception {
        action = new ConsoleFightAction(new Player(20,null), new Enemy(100,20,null, "Monk"));
        action.setDisplayer(new TestConsoleDisplayer());
    }

    @Test
    public void act() throws Exception {
        boolean playerFirst = action.isPlayersTurn();
        FightActionOutcome fightActionOutcome = action.act();
        assertTrue(playerFirst ? fightActionOutcome.winner instanceof Player : fightActionOutcome.winner instanceof Enemy);
        TestConsoleDisplayer displayer = (TestConsoleDisplayer) action.displayer;
        for (String message :
                displayer.getMessages()) {
            System.out.println(message);
        }
    }

}