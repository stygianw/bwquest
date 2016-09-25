package ua.stygianw.quest.cells;

import ua.stygianw.quest.player.Enemy;

/**
 * Created by User on 25.09.2016.
 */
public class EnemyCell extends QuestCell {
    private Enemy enemy;

    private EnemyCell(QuestCellBuilder builder) {
        super(builder);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
