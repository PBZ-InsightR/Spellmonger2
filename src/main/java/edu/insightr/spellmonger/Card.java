package edu.insightr.spellmonger;

public class Card {
    private String name;
    private int energyCost;
    private int damage;

    public Card() {
        this.name = "NONE";
        this.energyCost = 0;
        this.damage = 0;
    }

    public Card(String name,int energyCost,int damage) {
        this.name = name;
        this.energyCost = energyCost;
        this.damage = damage;
    }

    public String toString() {
        return "La carte " + this.name + " fait " + this.damage + " dommages et coute " + this.energyCost + " énergie";
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
