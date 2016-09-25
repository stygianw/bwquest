package ua.stygianw.quest.player;

/**
 * Created by User on 25.09.2016.
 */
public abstract class AbstractItem {
    final int extent;
    private String description;

    public AbstractItem(String description, int extent) {
        this.description = description;
        this.extent = extent;
    }

    public String getDescription() {
        return description;
    }

    abstract void affectPlayer(Player player);
}
