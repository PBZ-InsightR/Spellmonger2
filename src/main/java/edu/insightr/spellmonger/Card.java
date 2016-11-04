package edu.insightr.spellmonger;

public class Card {
    private String name;
    private int damage;

    private int energy;

    private int energyCost;


   public Card(String name) {
        this.name = name;
        energyCost=0;
        damage = 0;
    }


    public String toString() {
        return "La carte "+this.name+" fait "+ this.damage +" dommages et coute "+this.energyCost+" énergie";
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return this.energy;


    public int getEnergyCost() {
        return energyCost;

    }
}
