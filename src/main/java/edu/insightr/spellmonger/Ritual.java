package edu.insightr.spellmonger;


public class Ritual {
    private String nameRitual;
    private int damage;
    public Ritual(String nameRitual) {
        this.nameRitual=nameRitual;
        if (nameRitual=="Curse")
        {
            this.damage=3;
        }
        if (nameRitual=="Blessing")
        {
            this.damage=-3;
        }

    }

    public int getDamage(){
        return damage;
    }
    public String getNameRitual() {return nameRitual;}




}
