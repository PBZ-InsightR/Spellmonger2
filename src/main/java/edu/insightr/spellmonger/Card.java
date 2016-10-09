package edu.insightr.spellmonger;

/**
 * Created by Etienne on 04/10/2016.
 */
public class Card {
    private Creature creature;
    private Ritual ritual;

    public Card(Creature creature) {
        this.creature=creature;
        this.ritual=null;
    }

    public Card(Ritual ritual){
        this.ritual=ritual;
        this.creature=null;
    }

    public String toString() {
        return "type= ";
    }

    public Creature GetCreature() {
        return creature;
    }

    public Ritual GetRitual() {
        return ritual;
    }

    public boolean IsCreature(){
        boolean isCreature=true;
        if(creature==null){
            isCreature=false;
        }
        return isCreature;
    }
}