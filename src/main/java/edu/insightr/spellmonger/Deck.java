package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Etienne on 03/10/2016.
 */
public class Deck {
    List<Card> cardPool = new ArrayList<>(70);
    List<Card> discard = new ArrayList<>(70);
    static Random rand = new Random();
    private int nbRand=0;

    public Deck()
    {

    }

    //initialisation aléatoire du deck
    public List<Card> InitDeck()
    {
        Card carte;
        for (int i = 0; i < 70; i++)
        {
            nbRand=rand.nextInt(6 - 1 + 1) +1;
            if(nbRand==1)
            {
                carte=new Card("Ritual");
                cardPool.add(carte);
            }
            else
            {
                carte=new Card("Creature");
                cardPool.add(carte);
            }
        }

        return cardPool;
    }

    public void AjouterCard(Card carte)
    {
        discard.add(carte);
    }

    public void RetirerCard(Card carte)
    {
        discard.remove(carte);
    }

    //retourne objet carte contenant son nom, son type et ses dégâts
    public Card drawCard(int currentCardNumber,List<Card> deck)
    {

        Card carte=new Card("");

        if("Creature".equalsIgnoreCase(deck.get(currentCardNumber).getType()))
        {
            carte=new Card("Creature");
        }
        else
        {
            carte=new Card("Ritual");
        }
        return carte;

        //String card="";
        /*if ("Creature".equalsIgnoreCase(deck.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0){
                Creature eagle = new Creature("Eagle");
                carte=new Card(eagle.getName(),"Creature",eagle.getDamage());
                //discard.add(card);
            }
            else if (randNb == 1){
                Creature wolf = new Creature("Wolf");
                carte=new Card(wolf.getName(),"Creature",wolf.getDamage());
                //discard.add(card);
            }
            else if(randNb == 2){
                Creature bear = new Creature("Bear");
                carte=new Card(bear.getName(),"Creature",bear.getDamage());
                //discard.add(card);
            }
        }
        else if("Ritual".equalsIgnoreCase(deck.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(2);
            if (randNb == 0) {
                Ritual curse = new Ritual("Curse");
                carte=new Card(curse.getName(),"Ritual",curse.getDamage());
                //discard.add(card);
            }
            else if(randNb == 1) {
                Ritual blessing = new Ritual("Blessing");
                carte=new Card(blessing.getName(),"Ritual",blessing.getDamage());
                //discard.add(card);
            }
        }*/
    }
}
