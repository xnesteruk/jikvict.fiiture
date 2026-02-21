package org.jikvict.tasks.exposed;

public abstract class GameCharacter {
    private String name;
    private int health;
    private int maxHealth;
    private int baseAttackPower;
    private int level;
    private String weapon;
    private boolean alive;

    // Constructor
    public GameCharacter(String name, int maxHealth, int baseAttackPower, int level, String weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.baseAttackPower = baseAttackPower;
        this.level = level;
        this.weapon = weapon;
        this.health = maxHealth;
        this.alive = true;
    }

    // Abstract methods
    public abstract String getCharacterType();
    public abstract int calculateDamage();

    // Concrete methods
    public String getInfo() {
        return String.format("%s: Level %d, Health: %d/%d, Weapon: %s", name, level, health, maxHealth, weapon);
    }

    public int attack() {
        return baseAttackPower;
    }

    public int attack(int extraDamage) {
        return baseAttackPower + extraDamage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public void levelUp() {
        level++;
        maxHealth += 10; // Example increase
        baseAttackPower += 2; // Example increase
    }

    @Override
    public String toString() {
        return getInfo();
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getBaseAttackPower() { return baseAttackPower; }
    public int getLevel() { return level; }
    public String getWeapon() { return weapon; }
    public boolean isAlive() { return alive; }
    
    public void setName(String name) { this.name = name; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setBaseAttackPower(int baseAttackPower) { this.baseAttackPower = baseAttackPower; }
    public void setLevel(int level) { this.level = level; }
    public void setWeapon(String weapon) { this.weapon = weapon; }
}