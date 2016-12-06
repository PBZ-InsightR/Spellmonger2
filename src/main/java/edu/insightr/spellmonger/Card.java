package edu.insightr.spellmonger;

public class Card {
    private String name;
    private int energyCost;
    private int damage;
    private String urlPicture;
    private String type;


    public Card() {
        this.name = "NONE";
        this.energyCost = 0;
        this.damage = 0;
        this.urlPicture = "carte.jpg";
        this.type="NONE";
    }

    public Card(String name, int energyCost, int damage, String urlPicture, String type) {
        this.name = name;
        this.energyCost = energyCost;
        this.damage = damage;
        this.urlPicture = urlPicture;
        this.type=type;
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

    public String getUrlPicture() {
        return this.urlPicture;
    }

    public String getType() {
        return this.type;
    }
}
