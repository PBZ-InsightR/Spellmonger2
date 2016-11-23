package edu.insightr.spellmonger;

import java.util.Enumeration;


public class Creature extends Card {
    //private EnumCard enumCard;
    private String capacity;
    private int PV;

    public Creature(String animal) {
        super(animal);
        switch (animal) {
            case "Eagle":
                this.name = "Eagle";
                this.PV = 1;
                this.damage = 1;
                this.energyCost = 1;
                this.capacity = "Flying";
                break;
            case "Wolf":
                this.name = "Wolf";
                this.PV = 2;
                this.damage = 2;
                this.energyCost = 2;
                this.capacity = "None";
                break;
            case "Bear":
                this.name = "Bear";
                this.PV = 3;
                this.damage = 3;
                this.energyCost = 3;
                this.capacity = "None";
                break;
            case "Fox":
                this.name = "Fox";
                this.PV = 1;
                this.damage = 1;
                this.energyCost = 1;
                this.capacity = "None";
                break;
        }
    }

    public int getPV() {
        return this.PV;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public boolean isAlive() {
        boolean result= false;
        if (this.PV > 0) {
            result = true;
        }
        return result;
    }

    public void alterePV(int damage) {
        this.PV -= damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getEnergyCost() {
        return this.energyCost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String toString() {
        return "La créature " + this.name + "a" + this.PV + "point de vie" + "(capacité :" + this.capacity + ")" + " fait " + getDamage() + " points de dégats";
    }
}
