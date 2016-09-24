package edu.insightr.spellmonger;

/**
 * Created by Karim_Utilisateur on 24/09/2016.
 */
public class Ritual {

    public final int damage = 0;
    private int curse, blessing;

    public Ritual()
    {
        this.curse = damage - 3;
        this.blessing = damage + 3;
    }

    public int getCurse(){
        return curse;
    }

    public int getBlessing(){
        return blessing;
    }
}
