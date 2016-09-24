package edu.insightr.spellmonger;

/**
 * Created by Etienne on 24/09/2016.
 */
public class Creature {
    private String nameC;
    private int dmg;

    public Creature(String nameC)
    {
        this.nameC=nameC;
        if(nameC=="Eagle") dmg=1;
        if(nameC=="Wolf") dmg=2;
        if(nameC=="Bear") dmg=3;
    }

    public String NameC(){
        return nameC;
    }

    public int Dmg(){
        return dmg;
    }

    public String toString()
    {
        return "Name="+nameC+" Damage="+dmg;
    }
}
