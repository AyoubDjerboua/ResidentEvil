package com.youbiz.residentevil;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerDamage;
    private int blockValue;

    public Player (String name, int health, int damage, int block)
    {
        this.playerName = name;
        this.playerHealth = health;
        this.playerDamage = damage;
        this.blockValue = block;
    }

    public void attack(Zombie zombie)
    {
        System.out.println(playerName + " attaque le " + zombie.getName());
        zombie.takeDamage(playerDamage);
    }

    public void takeDamage(int damage)
    {
        playerHealth -= damage;
        System.out.println(playerName + " perd " + damage + " points de vie !");
    }

    public void takeDamageBlocked(int damage)
    {
        int reduced = damage - blockValue;
        if(reduced < 0) reduced = 0;
        playerHealth -= reduced;
        System.out.println(playerName + " bloque l'attaque et ne perd que " + reduced + " points de vie !");
    }

    public boolean isAlive()
    {
        return playerHealth > 0;
    }

    //Getters et setters
    public String getName() {
        return playerName;
    }

    public int getHealth() {
        return playerHealth;
    }

    public int getDamage() {
        return playerDamage;
    }

    public int getBlockValue() {
        return blockValue;
    }
}
