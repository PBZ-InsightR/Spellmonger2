package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nass on 26/09/2016.
 */
public class Player {
    private String name;
    private int lifePoints;
    private List<Creature> listeCreature; //Liste des créatures du joueur
    private Deck pioche;
    private Deck fausse;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.listeCreature = new ArrayList<>(0);
        pioche = new Deck(70);
        fausse = new Deck(0);
    }

    public String GetName() {
        return this.name;
    }

    public void Machin(){

    }

    public int GetLifePoints() {
        return this.lifePoints;
    }

    public List<Creature> GetListeCreature() {
        return this.listeCreature;
    }

    public Deck getPioche() {
        return pioche;
    }

    public Deck getFausse() {
        return fausse;
    }

    public boolean IsAlive() {
        boolean isAlive = true;
        if (this.lifePoints <= 0) {
            isAlive = false;
        }
        return isAlive;
    }

    public void AltererHP(int dmg) {
        this.lifePoints -= dmg;
    }

    public String toString() {
        return "Le joueur " + this.name + " a " + this.lifePoints + " points de vie";
    }


}
