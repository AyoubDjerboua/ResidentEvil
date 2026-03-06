package com.youbiz.residentevil.model;

public class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int damage;
    protected int defense;
    protected int block;
    protected int position;

    public Player (String name, int health, int damage, int defense, int block)
    {
        this.name = name;
        this.health = health;
        this.maxHealth = health; // on garde en tête les PV max des persos pour éviter de dépasser ce seuil lors des soins
        this.damage = damage;
        this.defense = defense;
        this.block = block;
        this.position = 0;
    }

    public void attack(Enemy enemy)
    {
        System.out.println(name + " attaque à "+ damage + " le " + enemy.getName());
        enemy.takeDamage(damage);
    }

    public void block(int damage)
    {
        int actualDamageBlocked = block - defense;
        if(actualDamageBlocked < 0) actualDamageBlocked = 0; //pour éviter de se heal sur des attaques
        health -= actualDamageBlocked;
        System.out.println(name + " bloque l'attaque et ne perd que " + actualDamageBlocked + " points de vie !");
    }

    public void takeDamage(int damage)
    {
        int actualDamage = damage - defense;
        if(actualDamage < 0) actualDamage = 0; //pour éviter de se heal sur des attaques
        health -= actualDamage;
        System.out.println(name + " perd " + actualDamage + " points de vie !");
    }

    public void heal (int amount)
    {

        if(health >= maxHealth) {
            System.out.println(name + " est déjà au max");
            return; //retourne pour éviter de faire les calculs suivants
        }
        else {
            health += amount;
            if(health > maxHealth) health = maxHealth; //pour éviter de dépasser les PV max
            System.out.println(name + " récupère " + amount + " points de vie !");
        }
    }

    public void move(int steps)
    {
        position += steps;
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    // Méthode pratique pour afficher toutes les stats
    @Override
    public String toString() {
        return name + " (" + health + " HP, " + damage + " dégâts, " + defense + " défense)";
    }


    //Getters et setters
    public String getName() { return name; }

    public int getHealth() { return health; }

    public int getDamage() { return damage; }

    public int getBlock() { return block; }

    public int getPosition() { return position; }

    public int getMaxHealth() { return maxHealth; }
}

