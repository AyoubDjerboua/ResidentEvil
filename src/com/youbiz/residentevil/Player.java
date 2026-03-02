package com.youbiz.residentevil;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerDamage;

    public Player ()
    {
        this.playerName = "Chris Redfield";
        this.playerHealth = 100;
        this.playerDamage = 25;
    }

    public void takeDamage(int damage)
    {
        playerHealth -= damage;
        System.out.println(playerName + " perd " + damage + " points de vie !");
    }

    public boolean isAlive() {
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



}
