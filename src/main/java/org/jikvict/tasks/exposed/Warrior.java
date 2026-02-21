package org.jikvict.tasks.exposed;

public class Warrior extends GameCharacter {
    private int armorRating;

    public Warrior(String name, int health, int baseAttackPower, int armorRating) {
        super(name, health, baseAttackPower, 1, null);
        this.armorRating = armorRating;
    }

    @Override
    public String getCharacterType() {
        return "Warrior";
    }

    @Override
    public int calculateDamage() {
        return baseAttackPower + (armorRating / 2);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(0, damage - (armorRating / 3));
        super.takeDamage(reducedDamage);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Armor: " + armorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }
}