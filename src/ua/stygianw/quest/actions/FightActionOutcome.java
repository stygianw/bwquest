package ua.stygianw.quest.actions;

import ua.stygianw.quest.player.Being;

/**
 * Created by User on 25.09.2016.
 */
public class FightActionOutcome extends ActionOutcome {

    public final Being winner;
    public final Being loser;

    public FightActionOutcome(Being winner, Being loser) {
        this.winner = winner;
        this.loser = loser;
    }
}
