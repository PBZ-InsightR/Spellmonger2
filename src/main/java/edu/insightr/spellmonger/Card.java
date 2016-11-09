package edu.insightr.spellmonger;

public class Card {
    private String name;
    private int damage;

    private int energy;

    private int energyCost;


   public Card(String name) {
        this.name = name;
        energyCost=0;
        damage = 2;
    }


    public String toString() {
        return "La carte "+this.name+" commet "+ this.damage +" dommages et coûte "+this.energyCost+" énergie";
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getEnergyCost() {
        return energyCost;
    }
}
