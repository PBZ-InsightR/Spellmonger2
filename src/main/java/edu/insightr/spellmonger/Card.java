package edu.insightr.spellmonger;

public class Card {
    private String name;
    private int energyCost;
    private int damage;
    private String urlPicture;


    public Card() {
        this.name = "NONE";
        this.energyCost = 0;
        this.damage = 0;
        this.urlPicture = "carte.jpg";
    }

    public Card(String name,int energyCost,int damage,String urlPicture) {
        this.name = name;
        this.energyCost = energyCost;
        this.damage = damage;
        this.urlPicture = urlPicture;
    }

    public String toString() {
        return "La carte " + this.name + " fait " + this.damage + " dommages et coute " + this.energyCost + " énergie";
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergyCost() {
        return this.energyCost;
    }

    public String getUrlPicture() { return this.urlPicture; }
}
