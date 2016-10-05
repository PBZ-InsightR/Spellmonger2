package edu.insightr.spellmonger;

/**
 * Created by Etienne on 04/10/2016.
 */
public class Card {
    private String name;
    private String type;
    private int dmg;

    public Card(String name,String type,int dmg)
    {
        this.name=name;
        this.type=type;
        this.dmg=dmg;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDmg() {
        return dmg;
    }

    public String toString(){
        return "La carte "+name+" de type "+type+" possède "+dmg+" dégâts";
    }
}
