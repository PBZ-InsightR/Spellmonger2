package edu.insightr.spellmonger;

public class Card {
    private String name;
    private int damage;

    public Card(String name) {
        this.name = name;
        damage = 0;
    }

    public String toString() {
        return "type= ";
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return name;
    }
}