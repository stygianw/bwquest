package ua.stygianw.quest.player;

/**
 * Created by User on 25.09.2016.
 */
public abstract class Being {
    int hp;

    public int getDamage() {
        return damage;
    }

    int damage = 20;

    public int getHp() {
        return hp;
    }

    void acceptHit(int hp) {
        this.hp -= hp;
    }

    public abstract void hit(Being being);

    public boolean isDead() {
        return this.hp == 0;
    }
}
