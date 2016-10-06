package edu.insightr.spellmonger;

/**
 * Created by Etienne on 04/10/2016.
 */
public class Card {
    private Creature creature;
    private Ritual ritual;
    private boolean isCreature;

    public Card(Creature creature) {
        this.creature = creature;
        ritual = null;
        isCreature=true;
    }

    public Card(Ritual ritual) {
        this.ritual = ritual;
        creature = null;
        isCreature=false;
    }

    public Creature GetCreature(){
        return this.creature;
    }

    public Ritual GetRitual(){
        return this.ritual;
    }

    public boolean GetIsCreature(){
        return this.isCreature;
    }
}