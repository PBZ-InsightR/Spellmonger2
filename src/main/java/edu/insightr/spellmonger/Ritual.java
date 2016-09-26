package edu.insightr.spellmonger;

/**
 * Created by Théo on 25/09/2016.
 */
public class Ritual {

    private int damage;
    private String ritualName;


    public Ritual(String ritualName){
        this.ritualName = ritualName;
        if (ritualName.equals( "Curse"))
            this.damage = 3;
        if (ritualName.equals("Blessing"))
            this.damage = -3;
        if(ritualName.equals("Energy drain"))
            this.damage=0;


    }

    public int getDamage() {
        return damage;
    }

    public String toString(){
        String message="";
        if(ritualName.equals("Curse")){
            message="Le rituel fait "+this.damage+" points de dégat";
        }
        else if(ritualName.equals("Blessing")){
            message="Le rituel soigne"+this.damage+" points de vie";
        }
        return message;
    }
}
