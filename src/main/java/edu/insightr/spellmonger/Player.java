package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int lifePoints;
    private List<Creature> listeCreature; //Liste des créatures du joueur
    private List<Card> main;
    private Deck pioche;
    private Deck fausse;
    private int energy;

    public Player(String name, int lifePoints, int energy) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.listeCreature = new ArrayList<>(0);
        this.main=new ArrayList<>(0);
        pioche = new Deck(40);
        fausse = new Deck(0);
        this.energy = energy;
    }

    public String getName() {
        return this.name;
    }


    public int getLifePoints() {
        return this.lifePoints;
    }

    public List<Creature> getListeCreature() {
        return this.listeCreature;
    }

    public Deck getPioche() {
        return pioche;
    }

    public Deck getFausse() {
        return fausse;
    }

    public boolean isAlive() {
        boolean isAlive = true;
        if (this.lifePoints <= 0) {
            isAlive = false;
        }
        return isAlive;
    }

    public void altererHP(int dmg) {
        this.lifePoints -= dmg;
    }

    public String toString() {
        return "Le joueur " + this.name + " a " + this.lifePoints + " points de vie";
    }


    public int getEnergy() {
        return energy;
    }

    public void removeEnergy(int energy){
        this.energy-=energy;
    }

}
