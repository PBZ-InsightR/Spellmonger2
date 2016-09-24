package edu.insightr.spellmonger;

/**
 * Created by Karim_Utilisateur on 24/09/2016.
 */
public class Creature {
    public final int damage = 0;
    private int attackEagle, attackWolf, attackBear;
    public Creature()
    {
        this.attackEagle = damage - 1;
        this.attackBear = damage - 3;
        this.attackWolf = damage - 2;
    }

    public int getAttackBear(){
        return attackBear;
    }

    public int getAttackEagle(){
        return attackEagle;
    }

    public int getAttackWolf(){
        return attackWolf;
    }
}
