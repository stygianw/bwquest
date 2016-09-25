package ua.stygianw.quest.player;

/**
 * Created by User on 25.09.2016.
 */
class IncreasingDamageItem extends AbstractItem {

    public IncreasingDamageItem(String description, int extent) {
        super(description, extent);
    }

    @Override
    void affectPlayer(Player player) {
        player.increaseDamage(extent);
    }
}
