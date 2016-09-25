package ua.stygianw.quest.actions;

import ua.stygianw.quest.player.Being;
import ua.stygianw.quest.player.Enemy;
import ua.stygianw.quest.player.Player;

import java.util.Random;

/**
 * Created by User on 25.09.2016.
 */
public abstract class FightAction implements PlayerAction {

    public final Player player;
    public final Enemy enemy;

    private final PlayerTurn playerTurn;
    private final EnemyTurn enemyTurn;

    private Turn turn;

    public FightAction(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        playerTurn = new PlayerTurn();
        enemyTurn = new EnemyTurn();
        setParties(new Random().nextInt(12));
    }

    void setParties(int randomSeed) {
        if(randomSeed % 2 == 0 ) {
            turn = playerTurn;
        } else {
            turn = enemyTurn;
        }
    }

    public Turn getTurn() {
        return turn;
    }

    public boolean isPlayersTurn() {
        return turn instanceof PlayerTurn;
    }

    public boolean isEnemyTurn() {
        return turn instanceof EnemyTurn;
    }

    public void turn() {
        turn.attack();
    }

    public boolean gameOver() {
        return player.isDead() || enemy.isDead();
    }

    public abstract class Turn{
        Being attackingBeing;
        Being victimBeing;

        void attack() {
            attackingBeing.hit(victimBeing);
        }

        public Being getAttackingBeing() {
            return attackingBeing;
        }

        public Being getVictimBeing() {
            return victimBeing;
        }
    }

    class PlayerTurn extends Turn {
        PlayerTurn() {
            this.attackingBeing = player;
            this.victimBeing = enemy;
        }

        @Override
        void attack() {
            super.attack();
            if(victimBeing.getHp() > 0) {
                turn = enemyTurn;
            }
        }
    }

    class EnemyTurn extends Turn {
        EnemyTurn() {
            this.attackingBeing = enemy;
            this.victimBeing = player;
        }

        @Override
        void attack() {
            super.attack();
            if(victimBeing.getHp() > 0) {
                turn = playerTurn;
            }
        }
    }
}
