package edu.insightr.spellmonger;

public class Card {
    protected String name;
    protected int damage;
    protected int energyCost;

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

    public int getEnergyCost() {
        return energyCost;
    }
}
