package edu.insightr.spellmonger;

/**
 * Created by Karim_Utilisateur on 05/10/2016.
 */
public class Plateau {
    private Player p1, p2;
    private int nbTours;
    private boolean gagnant; // Ca serait pas plus logique de le mettre dans la classe Player?

    public Plateau(Player p1, Player p2 , int nbTours, boolean gagnant)
    {
        this.gagnant = gagnant;
        this.nbTours = nbTours;
        this.p1 = p1;
        this.p2 = p2;
    }
    public int getNbTours(){
        return nbTours;
    }
    public Player getP1(){
        return p1;
    }

    public Player getP2(){
        return p2;
    }
    public boolean getGagnant(){
        return gagnant;
    }


    public Player CalculDegat(Card c, Player p)
    {
        if(c.getType().equals("Creature")){
            if(c.getName().equals("Eagle")) {
                p.AltererHP(1);
            }
            if(c.getName().equals("Wolf")) {
                p.AltererHP(2);
            }
            if(c.getName().equals("Bear")) {
                p.AltererHP(3);
            }
    }
        if(c.getType().equals("Ritual")){
            if(c.getName().equals("Curse")) {
                p.AltererHP(3);
            }
            if(c.getName().equals("Blessing")) {
                p.AltererHP(-3);
            }

    }
        return p;
    }



}
