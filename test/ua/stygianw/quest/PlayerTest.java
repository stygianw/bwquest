package ua.stygianw.quest;

import org.junit.Before;
import org.junit.Test;
import ua.stygianw.quest.player.Enemy;
import ua.stygianw.quest.player.Player;
import ua.stygianw.quest.player.Weapon;

import static org.junit.Assert.assertTrue;

/**
 * Created by User on 25.09.2016.
 */
public class PlayerTest {

    Enemy enemy;
    Player player;

    @Before
    public void setUp() throws Exception {
        enemy = new Enemy(100, 20, null);
        player = new Player(20, null);
    }

    @Test
    public void testHit() throws Exception {

        player.hit(enemy);
        assertTrue(enemy.getHp() == 80);

    }

    @Test
    public void playerHitWithWeapon() throws Exception {
        Weapon weapon = new Weapon("weapon1", 20);
        player.addWeapon(weapon);
        player.selectWeapon(weapon);
        player.hit(enemy);
        assertTrue(enemy.getHp() == 60);

    }


}