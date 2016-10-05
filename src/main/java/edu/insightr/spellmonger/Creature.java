package edu.insightr.spellmonger;

/**
 * Created by Walidey on 21/09/2016.
 */
public class Creature extends Card {

    private int damage;
    private String capacity;
    private int PV;



    public Creature(String name, String type) {
        super(name, type);
        type="creature";
        if (name == "Eagle") {
            this.damage = 1;
            this.capacity = "Flying";
            this.PV = 1;

        } else if (name == "Wolf") {
            this.damage = 2;
            this.PV=2;
            this.capacity = "None";

        } else if (name == "Bear") {
            this.damage = 3;
            this.PV = 3;
            this.capacity = "None";

        }
    }

    public int getDamage() {
        return damage;
    }
    public int getPV() {return PV;}

    public String getCapacity() {return capacity;}

    public boolean IsAlive()    {
        if (getPV()>0)
        {
            return true;
        }
    else{
            return false;

        }


    }

    public String toString(){
        return "La créature "+getName()+"a"+this.PV+"point de vie"+"(capacité :"+ this.capacity+")"+ " fait "+this.damage+" points de dégat";
    }
}
