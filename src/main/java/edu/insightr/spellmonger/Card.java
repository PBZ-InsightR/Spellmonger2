package edu.insightr.spellmonger;

/**
 * Created by Etienne on 04/10/2016.
 */
public class Card {
    private String name;
    private String type;
    private int damage;
    
    public Card(String name,String type, int damage)
    {
        this.name=name;
        this.type=type;
        this.damage = damage;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public String toString(){
        return "type= "+type;
    }


    public int getDamage() {
        return damage;
    }
}