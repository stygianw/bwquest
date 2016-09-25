package ua.stygianw.quest.actions.consoleimpl;

import ua.stygianw.quest.actions.FightAction;
import ua.stygianw.quest.actions.FightActionOutcome;
import ua.stygianw.quest.player.Enemy;
import ua.stygianw.quest.player.Player;

/**
 * Created by User on 25.09.2016.
 */
class ConsoleFightAction extends FightAction {

    MessageDisplayer displayer = new ConsoleDisplayer();

    public ConsoleFightAction(Player player, Enemy enemy) {
        super(player, enemy);
    }

    void setDisplayer(MessageDisplayer displayer) {
        this.displayer = displayer;
    }

    String showMessage(Messages message, Integer hp) {
        String result = null;
        if(isPlayersTurn()) {
            result = message.playerMessage.formatMessage(enemy.shortdesc, hp);
        } else if (isEnemyTurn()){
            result = message.enemyMessage.formatMessage(enemy.shortdesc, hp);
        }
        return result;
    }


    @Override
    public FightActionOutcome act() {
        int damage = getTurn().getAttackingBeing().getDamage();
        displayer.display(showMessage(Messages.FIRST_ATTACKER, damage));
        holdBattleConsole();
        while(!gameOver()) {
            turn();
            displayer.display(showMessage(Messages.HIT, damage));
            displayer.display(showMessage(Messages.REMAINING, damage));
            holdBattleConsole();
        }
        displayer.display(showMessage(Messages.DEAD, damage));
        return new FightActionOutcome(getTurn().getAttackingBeing(), getTurn().getVictimBeing());


    }

    private void holdBattleConsole() {
        displayer.holdConsole("Press a key to continue the battle.");
    }

    private enum Messages {

        FIRST_ATTACKER((enemyName, hp) -> {
            return String.format("You were faster than %s and you can attack him first!", enemyName.toLowerCase());
        }, (enemyName, hp) -> {
            return String.format("%s was faster and attacks you first!", enemyName);
        }),
        HIT((enemyName, hp) -> {
            return String.format("You hit %s and took %d hp of his health", enemyName, hp);
        }, (enemyName, hp) -> {
            return String.format("%s hit you and took %d percent of his health", enemyName, hp);
        }),
        REMAINING((enemyName, hp) -> {
            return String.format("You have %d hp remaining", hp);
        }, (enemyName, hp) -> {
            return String.format("%s has %d hp remaining", enemyName, hp);
        }),
        DEAD((enemyName, hp) -> {
            return String.format("%s is dead!", enemyName);
        }, (enemyName, hp) -> {
            return String.format("You were killed by the %s!", enemyName);
        });
        ConsoleMessageFormatter playerMessage;
        ConsoleMessageFormatter enemyMessage;

        Messages(ConsoleMessageFormatter s, ConsoleMessageFormatter s1) {
            this.playerMessage = s;
            this.enemyMessage = s1;
        }
    }

    private interface ConsoleMessageFormatter {
        String formatMessage(String enemyName, Integer hp);
    }
}
