package edu.insightr.spellmonger;

public class Creature {
    public int damage;
    private String name;

    public Creature(String name) {
        this.name = name;
        if (name=="Eagle")
        {
            this.damage=1;
        }
        if (name=="Wolf")
        {
            this.damage=2;
        }
        if (name=="Bear")
        {
            this.damage=3;
        }
    }



    public int getDamage() {
        return damage;
    }
    public String getName() {return name;}
}

