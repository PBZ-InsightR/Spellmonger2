package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Etienne on 03/10/2016.
 */
public class Deck {


    private List<Card> cardPool;
    private int nombreDeCartes;
    static Random rand;
    private int nbRand;

    public Deck(int nombreDeCartes) {
        rand = new Random();
        nbRand = 0;
        cardPool=new ArrayList<Card>();
        cardPool=this.InitDeck();
        this.nombreDeCartes=nombreDeCartes;
    }

    // Initialisation aléatoire du deck
    public List<Card> InitDeck() {
        Card carte;
        int i=1;
        while(i<=40){
            nbRand = rand.nextInt(6);
            if (nbRand == 0) {

                Ritual curse = new Ritual("Curse");
                carte = new Card(curse);
                cardPool.add(carte);
            }
            else if (nbRand == 1) {
                Ritual blessing = new Ritual("Blessing");
                carte = new Card(blessing);
                cardPool.add(carte);
            }
            else if (nbRand == 2) {
                Ritual energyDrain = new Ritual("Energy drain");
                carte = new Card(energyDrain);
                cardPool.add(carte);
            }
            else if (nbRand == 3) {
                Creature bear= new Creature("Bear");
                carte = new Card(bear);
                cardPool.add(carte);
            }
            else if (nbRand == 4) {
                Creature wolf= new Creature("Wolf");
                carte = new Card(wolf);
                cardPool.add(carte);
            }
            else if (nbRand == 5) {
                Creature eagle= new Creature("Eagle");
                carte = new Card(eagle);
                cardPool.add(carte);
            }
            i++;
        }
        return cardPool;
    }
    public List<Card> getCardPool() {
        return cardPool;
    }
    public void AjouterCard(Card carte) {
        cardPool.add(carte);
    }

    public void RetirerCard(Card carte) {
        cardPool.remove(carte);
    }

    public boolean isEmpty(){
        boolean isEmpty=false;
        if(cardPool.size()==0){
            isEmpty=true;
        }
        return isEmpty;
    }

    //La méthode retourne la dernière carte du paquet
    public Card drawCard() {
        /*int i = 0;
        while (!cardPool.isEmpty()) {
            i++;
        }*/
        return cardPool.get(cardPool.size()-1);

        /*if ("Creature".equalsIgnoreCase(deck.get(currentCardNumber).GetType())) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0) {
                carte = new Card("Eagle", "Creature");
            } else if (randNb == 1) {
                carte = new Card("Wolf", "Creature");
            } else if (randNb == 2) {
                carte = new Card("Bear", "Creature");
            }
        } else if ("Ritual".equalsIgnoreCase(deck.get(currentCardNumber).GetType())) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0) {
                carte = new Card("Curse", "Ritual");
            } else if (randNb == 1) {
                carte = new Card("Blessing", "Ritual");
            } else if (randNb == 2) {
                carte = new Card("Energy drain", "Ritual");
            }

        }*/
    }
}
