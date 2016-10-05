package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Etienne on 03/10/2016.
 */
public class Deck {
    List<String> cardPool = new ArrayList<>(70);
    List<String> discard = new ArrayList<>(70);
    static Random rand = new Random();
    private int nbRand=0;

    public Deck()
    {

    }

    //initialisation aléatoire du deck
    public List<String> InitDeck()
    {
        for (int i = 0; i < 70; i++)
        {
            nbRand=rand.nextInt(6 - 1 + 1) +1;
            if(nbRand==1)
            {
                cardPool.add("Ritual");
            }
            else
            {
                cardPool.add("Creature");
            }
        }

        return cardPool;
    }

    //retourne objet carte contenant son nom, son type et ses dégâts
    public Card drawCard(int currentCardNumber,List<String> deck)
    {
        String card="";
        Card carte=new Card("","",0);
        if ("Creature".equalsIgnoreCase(deck.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0){
                Creature eagle = new Creature("Eagle");
                carte=new Card(eagle.getName(),"Creature",eagle.getDamage());
                discard.add(card);
            }
            else if (randNb == 1){
                Creature wolf = new Creature("Wolf");
                carte=new Card(wolf.getName(),"Creature",wolf.getDamage());
                discard.add(card);
            }
            else if(randNb == 2){
                Creature bear = new Creature("Bear");
                carte=new Card(bear.getName(),"Creature",bear.getDamage());
                discard.add(card);
            }
        }
        else if("Ritual".equalsIgnoreCase(deck.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(2);
            if (randNb == 0) {
                Ritual curse = new Ritual("Curse");
                carte=new Card(curse.getName(),"Ritual",curse.getDamage());
                discard.add(card);
            }
            else if(randNb == 1) {
                Ritual blessing = new Ritual("Blessing");
                carte=new Card(blessing.getName(),"Ritual",blessing.getDamage());
                discard.add(card);
            }
        }
        return carte;
    }
}
