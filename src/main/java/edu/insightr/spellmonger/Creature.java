package edu.insightr.spellmonger;

/**
 * Created by Walidey on 21/09/2016.
 */
public class Creature extends Card {
    private String name;
    private int damage;
    private String capacity;
    private int PV;


    public Creature(String name, String type) {
        super(name, type);
        type = "creature";
        if (name == "Eagle") {
            this.name = name;
            this.damage = 1;
            this.capacity = "Flying";
            this.PV = 1;

        } else if (name == "Wolf") {
            this.name = name;
            this.damage = 2;
            this.PV = 2;
            this.capacity = "None";

        } else if (name == "Bear") {
            this.name = name;
            this.damage = 3;
            this.PV = 3;
            this.capacity = "None";

        }
    }

    @Override
    public String ToString() {
        return super.ToString() + "La créature " + name + "a" + this.PV + "point de vie" + "(capacité :" + this.capacity + ")" + " fait " + this.damage + " points de dégat";
    }

    public String GetName() {
        return name;
    }

    public int GetDamage() {
        return damage;
    }

    public int GetPV() {
        return PV;
    }

    public String GetCapacity() {
        return capacity;
    }

    public boolean IsAlive() {
        if (GetPV() > 0) {
            return true;
        } else {
            return false;

        }


    }
}
