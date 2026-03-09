package com.youbiz.residentevil.model;

public abstract class Enemy { // classe abstraite pour les ennemis, chaque type d'ennemi implémente ses propres caractéristiques
    protected String name;
    protected int health;
    protected int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // Méthode pour attaquer le joueur : chaque ennemi l'implémente différemment
    public void attack(Player player, boolean playerBlocks)
    {
        System.out.println(name + " attaque (" + damage + ")");
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " perd " + damage + " points de vie !");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}