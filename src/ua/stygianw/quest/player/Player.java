package ua.stygianw.quest.player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 25.09.2016.
 */
public class Player extends Being {

    private int maxHp = 100;

    private final String name;

    private Weapon selectedWeapon;

    private Set<Weapon> weapons = new HashSet<>();

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void selectWeapon(Weapon weapon) {
        if(weapons.contains(weapon)) {
            this.selectedWeapon = weapon;
        }
    }

    public Player(int damage, String name) {
        this.hp = 100;
        this.damage = damage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void heal(int extent) {
        this.hp += extent;
    }

    void poison(int extent) {
        this.hp -= extent;
    }

    void makeStronger(int extent) {
        this.maxHp += extent;
    }

    public void makeWeaker(int extent) {
        this.maxHp -= extent;
    }

    void increaseDamage(int extent) {
        this.damage -= extent;
    }

    void decreaseDamage(int extent) {
        this.damage -= extent;
    }

    @Override
    public void hit(Being being) {
        being.acceptHit(this.damage + Optional.ofNullable(selectedWeapon).map(Weapon::getDamageIncrease).orElse(0));
    }
}
