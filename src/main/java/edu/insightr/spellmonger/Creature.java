package edu.insightr.spellmonger;

/**
 * Created by Walidey on 21/09/2016.
 */
public class Creature {

    private int damage;
    private String capacity;
    private String name;
    private int PV;



    public Creature(String animal){
        if (animal == "Eagle") {
            this.damage = 1;
            this.capacity = "Flying";
            this.PV = 1;
            name = "Eagle";
        } else if (animal == "Wolf") {
            this.damage = 2;
            this.PV=2;
            this.capacity = "None";
            name="Wolf";
        } else if (animal == "Bear") {
            this.damage = 3;
            this.PV = 3;
            this.capacity = "None";
            name="Bear";
        }
    }


    public int getPV() {return PV;}

    public String getCapacity() {return capacity;}

    public boolean IsAlive()    {

    return false;

    }

    public String toString(){
        return "La créature "+this.name+"a"+this.PV+"point de vie"+"(capacité :"+ this.capacity+")"+ " fait "+this.damage+" points de dégat";
    }

    public void AlterePV(int damage) {
        this.PV -= damage;
    }

    public String GetName() {
        return name;
    }

    public int GetDamage(){
        return damage;
    }
}
