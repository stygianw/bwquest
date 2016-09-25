package ua.stygianw.quest.player;

/**
 * Created by User on 25.09.2016.
 */
public class Weapon {

    private String description;
    private int damageIncrease;

    public Weapon(String description, int damageIncrease) {
        this.description = description;
        this.damageIncrease = damageIncrease;
    }

    public String getDescription() {
        return description;
    }

    public int getDamageIncrease() {
        return damageIncrease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weapon weapon = (Weapon) o;

        return description.equals(weapon.description);

    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
