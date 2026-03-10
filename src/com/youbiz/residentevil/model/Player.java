package com.youbiz.residentevil.model;
import com.youbiz.residentevil.model.items.equipment.Weapon;

public class Player {
    protected String name;
    protected int health;
    protected int maxHealth; //garde
    protected int damage;//dgts de base sans armes
    protected int defense;//défense de base sans armures
    protected int block;
    protected int position;

    private Weapon weapon;

    public Player (String name, int health, int damage, int defense, int block)
    {
        this.name = name;
        this.health = health;
        this.maxHealth = health; // on garde en tête les PV max des persos pour éviter de dépasser ce seuil lors des soins
        this.damage = damage;
        this.defense = defense;
        this.block = block;
        this.position = 0;
        this.weapon = null; //le joueur commence sans arme
    }

    public void equipWeapon(Weapon newWeapon)
    {
        this.weapon = newWeapon;
        //System.out.println(name + " équipe " + weapon.getName() + " !");
    }

    public void attack(Enemy enemy)
    {
        int totalDamage = damage;
        if(weapon != null) totalDamage += weapon.getAttackBonus(); //ajoute les bonus de l'arme si le joueur en a une

        System.out.println(name + " attaque (" + totalDamage + ") !");
        enemy.takeDamage(totalDamage);
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

    public Weapon getWeapon() { return weapon; }
}

