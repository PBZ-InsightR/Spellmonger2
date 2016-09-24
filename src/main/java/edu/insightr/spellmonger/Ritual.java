package edu.insightr.spellmonger;

/**
 * Created by Etienne on 24/09/2016.
 */
public class Ritual {
    private String nameR;
    private int effect;

    public Ritual(String nameR)
    {
        this.nameR=nameR;
        if(nameR=="Curse") effect=3;
        if(nameR=="Blessing") effect=-3;
    }


    public String NameR(){
        return nameR;
    }

    public int Effect(){
        return effect;
    }

    public String toString()
    {
        return "Name="+nameR+" Damage="+effect;
    }
}
