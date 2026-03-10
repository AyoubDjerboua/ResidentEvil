package com.youbiz.residentevil.model.items;

public class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }
        //Top 10 des meilleurs Setters et Getters de tous les temps, le dixième va vous choquer
        public String getName() { return name; }
    @Override
    public String toString() {
        return name;
    }
}
