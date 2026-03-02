package com.youbiz.residentevil;

public class Zombie {
    private String zombieName;
    private int zombieHealth;
    private int zombieDamage;

    public Zombie (String zombieName, int zombieHealth, int zombieDamage)
    {
        this.zombieName = zombieName;
        this.zombieHealth = zombieHealth;
        this.zombieDamage = zombieDamage;
    }

    public void takeDamage(int damage) //quand le zombie se prend une attaque
    {
        zombieHealth -= damage; //réduit ses HP de "damage"
        System.out.println(zombieName + " perd " + damage + " points de vie");//message de bobo
    }

    public void attack(Player player)
    {
        System.out.println(zombieName + " attaque " + player.getName() + " !");
        player.takeDamage(zombieDamage);
    }

    public boolean isAlive() {
        return zombieHealth > 0;
    }

    public String getName() {
        return zombieName;
    }

    public int getHealth() {
        return zombieHealth;
    }

    public int getDamage() {
        return zombieDamage;
    }
}
