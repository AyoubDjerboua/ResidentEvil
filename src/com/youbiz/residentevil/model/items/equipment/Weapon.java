package com.youbiz.residentevil.model.items.equipment;
import com.youbiz.residentevil.model.items.Item;

public class Weapon extends Item {

    protected int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus(){ return attackBonus; }

    @Override
    public String toString() {
        return name + " (+" + attackBonus + " ATK)";
    }
}