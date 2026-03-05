package com.youbiz.residentevil.characters;

import com.youbiz.residentevil.enemies.Enemy;

public class Player {
    protected String playerName;
    protected int playerHealth;
    protected int maxHealth;
    protected int playerDamage;
    protected int playerDefense;
    protected int blockValue;
    protected int playerPosition;

    public Player (String name, int health, int damage, int defense, int block)
    {
        this.playerName = name;
        this.playerHealth = health;
        this.maxHealth = health; // on garde en tête les PV max des persos pour éviter de dépasser ce seuil lors des soins
        this.playerDamage = damage;
        this.playerDefense = defense;
        this.blockValue = block;
        this.playerPosition = 0;
    }

    public void attack(Enemy enemy)
    {
        System.out.println(playerName + " attaque le " + enemy.getName());
        enemy.takeDamage(playerDamage);
    }

    public void block(int damage)
    {
        int actualDamageBlocked = blockValue - playerDefense;
        if(actualDamageBlocked < 0) actualDamageBlocked = 0; //pour éviter de se heal sur des attaques
        playerHealth -= actualDamageBlocked;
        System.out.println(playerName + " bloque l'attaque et ne perd que " + actualDamageBlocked + " points de vie !");
    }

    public void takeDamage(int damage)
    {
        int actualDamage = damage - playerDefense;
        if(actualDamage < 0) actualDamage = 0; //pour éviter de se heal sur des attaques
        playerHealth -= actualDamage;
        System.out.println(playerName + " perd " + actualDamage + " points de vie !");
    }

    public void heal (int amount)
    {

        if(playerHealth >= maxHealth) {
            System.out.println(playerName + " est déjà au max");
            return; //retourne pour éviter de faire les calculs suivants
        }
        else {
            playerHealth += amount;
            if(playerHealth > maxHealth) playerHealth = maxHealth; //pour éviter de dépasser les PV max
            System.out.println(playerName + " récupère " + amount + " points de vie !");
        }
    }

    public void move(int steps)
    {
        playerPosition += steps;
    }

    public boolean isAlive()
    {
        return playerHealth > 0;
    }

    //Getters et setters
    public String getName() { return playerName; }

    public int getHealth() { return playerHealth; }

    public int getDamage() { return playerDamage; }

    public int getBlockValue() { return blockValue; }

    public int getPlayerPosition() { return playerPosition; }

    public int getMaxHealth() { return maxHealth; }
}

