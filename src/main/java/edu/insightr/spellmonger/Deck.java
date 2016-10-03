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

    public String drawCard(int currentCardNumber,List<String> deck)
    {
        String card="";
        if ("Creature".equalsIgnoreCase(deck.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0){
                card="Eagle";
                discard.add(card);
            }
            else if (randNb == 1){
                card="Wolf";
                discard.add(card);
            }
            else if(randNb == 2){
                card="Bear";
                discard.add(card);
            }
        }
        else if("Ritual".equalsIgnoreCase(deck.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(2);
            if (randNb == 0) {
                card="Curse";
                discard.add(card);
            }
            else if(randNb == 1) {
                card="Blessing";
                discard.add(card);
            }
        }
        return card;
    }
}
