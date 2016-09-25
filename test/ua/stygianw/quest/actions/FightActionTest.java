package ua.stygianw.quest.actions;

import org.junit.Before;
import org.junit.Test;
import ua.stygianw.quest.player.Enemy;
import ua.stygianw.quest.player.Player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 25.09.2016.
 */
public class FightActionTest {

    private FightAction action;

    @Before
    public void setUp() throws Exception {
        action = new FightAction(new Player(20, "Denis"), new Enemy(100, 20, null)) {
            @Override
            public ActionOutcome act() {
                return null;
            }
        };

    }

    @Test
    public void setPartiesTest() throws Exception {
        int seed = 8;
        action.setParties(seed);
        assertTrue(action.isPlayersTurn());

        seed = 9;

        action.setParties(seed);
        assertTrue(action.isEnemyTurn());

    }

    @Test
    public void turnTest() throws Exception {
        action.setParties(8);
        action.turn();
        assertTrue(action.enemy.getHp() == 80);
        action.turn();
        assertTrue(action.player.getHp() == 80);
        action.turn();
        action.turn();
        action.turn();
        action.turn();
        action.turn();
        action.turn();
        assertFalse(action.gameOver());
        action.turn();
        assertTrue(action.gameOver());
    }


}