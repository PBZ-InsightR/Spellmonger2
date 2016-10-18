package edu.insightr.spellmonger;

public class Creature extends Card {
    private String capacity;
    private String name;
    private int PV;

    public Creature(String animal) {
        super(animal);
        switch (animal) {
            case "Eagle":
                this.capacity = "Flying";
                this.PV = 1;
                name = "Eagle";
                break;
            case "Wolf":
                this.PV = 2;
                this.capacity = "None";
                name = "Wolf";
                break;
            case "Bear":
                this.PV = 3;
                this.capacity = "None";
                name = "Bear";
                break;
            case "Fox":
                this.PV=1;
                this.capacity="None";
                this.name="Fox";
                break;
        }
    }

    public int getPV() {
        return PV;
    }

    public String getCapacity() {
        return capacity;
    }

    public boolean isAlive() {
        boolean resultat = false;
        if (this.PV >= 0) {
            resultat = true;
        }
        return resultat;

    }

    public String toString() {
        return "La créature " + this.name + "a" + this.PV + "point de vie" + "(capacité :" + this.capacity + ")" + " fait " + getDamage() + " points de dégat";
    }

    public void alterePV(int damage) {
        this.PV -= damage;
    }

    @Override
    public int getDamage() {
        int damage = 0;
        switch (this.name) {
            case "Eagle":
                damage = 1;
                break;
            case "Wolf":
                damage = 2;
                break;
            case "Bear":
                damage = 3;
                break;
        }
        return damage;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
