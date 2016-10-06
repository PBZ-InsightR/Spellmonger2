package edu.insightr.spellmonger;

/**
 * Created by Etienne on 04/10/2016.
 */
public class Card {
    private String name;
    private String type;

    public Card(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public String GetName() {
        return name;
    }

    public String GetType() {
        return type;
    }


    public String ToString() {
        return "la carte est du type" + type+"son nom est"+name;
    }
}