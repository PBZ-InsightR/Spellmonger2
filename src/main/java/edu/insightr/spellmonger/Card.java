package edu.insightr.spellmonger;

/**
 * Created by Etienne on 04/10/2016.
 */
public class Card {
    private String name;
    private String type;

    public Card(String name,String type)
    {
        this.name=name;
        this.type=type;
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
}