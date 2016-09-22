package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean-Paul on 21/09/2016.
 */
public  class Creature {
    private int damage;
    private String animal;
    public Creature(String animal) {
        this.animal = animal;
        if (animal == "Eagle") {
            this.damage = 1;
        }
        else if(animal == "Wolf"){
            this.damage=2;
        }
        else if(animal == "Bear"){
            this.damage=3;
        }
        //rajouter ici les autres créatures
    }
    /*public boolean possibleCreature(String animal){
        List<String> creaturesPossibles=new ArrayList<String>();
        creaturesPossibles.add("Eagle");
        creaturesPossibles.add("Wolf");
        creaturesPossibles.add("Bear");
        //rajouter ici les autres créatures
        for(String s : creaturesPossibles)
        {
            if(animal==s) {
                return true;
            }
        }
        return false;
    }*/
}
