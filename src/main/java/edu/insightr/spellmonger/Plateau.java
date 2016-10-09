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
            p.GetLifePoints() -= c.getDamage();
    }
        if(c.getType().equals("Ritual")){
        p.GetLifePoints() -= c.getDamage();

    }
        return p;
    }



}
