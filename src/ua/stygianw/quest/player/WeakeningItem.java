package ua.stygianw.quest.player;

/**
 * Created by User on 25.09.2016.
 */
class WeakeningItem extends AbstractItem {

    public WeakeningItem(String description, int extent) {
        super(description, extent);
    }

    @Override
    void affectPlayer(Player player) {
        player.makeWeaker(extent);
    }
}
