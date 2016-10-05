package edu.insightr.spellmonger;

/**
 * Created by Théo on 21/09/2016.
 */
public class Creature {

    private int damage;
    private String animal;

    public Creature(String animal) {
        this.animal = animal;
        if (animal == "Eagle") {
            this.damage = 1;
        } else if (animal == "Wolf") {
            this.damage = 2;
        } else if (animal == "Bear") {
            this.damage = 3;
        }
    }

    public int getDamage() {
        return damage;
    }

    public String toString() {
        return "La créature " + this.animal + " fait " + this.damage + " points de dégat";
    }
}
