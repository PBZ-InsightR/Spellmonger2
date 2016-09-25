package edu.insightr.spellmonger;

/**
 * Created by Théo on 25/09/2016.
 */
public class Ritual {

    private int damage;
    private String ritualName;

    public Ritual(String ritualName){
        this.ritualName = ritualName;
        if (ritualName == "Curse")
            this.damage = 3;
        if (ritualName == "Blessing")
            this.damage = -3;
    }

    public int getDamage() {
        return damage;
    }
}
