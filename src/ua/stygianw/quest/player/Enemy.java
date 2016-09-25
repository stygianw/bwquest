package ua.stygianw.quest.player;

/**
 * Created by User on 25.09.2016.
 */
public class Enemy extends Being {

    public final String description;

    public final String shortdesc;

    public String getDescription() {
        return description;
    }

    public Enemy(int hp, int damage, String description) {
        this(hp, damage, description, null);
    }

    public Enemy(int hp, int damage, String description, String shortdesc) {
        this.hp = hp;
        this.damage = damage;
        this.description = description;
        this.shortdesc = shortdesc;
    }

    @Override
    public void hit(Being being) {
        being.acceptHit(this.damage);
    }
}
