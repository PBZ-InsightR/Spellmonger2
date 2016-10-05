package edu.insightr.spellmonger;

/**
 * Created by Théo on 25/09/2016.
 */
public class Ritual {

    private int damage;
    private String ritualName;
    private int energy =0;


    public Ritual(String ritualName){
        this.ritualName = ritualName;
        if (ritualName.equals( "Curse"))
            this.damage = 3;
        if (ritualName.equals("Blessing"))
            this.damage = -3;
        if(ritualName.equals("Energy drain"))
            this.damage=0;
        this.energy=2;


    }

    public String getName() {
        return ritualName;
    }

    public int getDamage() {
        return damage;
    }
    public int getEnergy() {
        return energy;
    }

    public String toString(){
        String message="";
        if(ritualName.equals("Curse")){
            message="Le rituel fait "+this.damage+" points de dégat";
        }
        else if(ritualName.equals("Blessing")){
            message="Le rituel soigne"+this.damage+" points de vie";
        }
        else if(ritualName.equals("Energy drain")){
            message="Le rituel vous donne"+this.energy+" points d'énergie et enlève"+this.energy+" points d'énergie à l'adversaire";
        }
        return message;
    }
}