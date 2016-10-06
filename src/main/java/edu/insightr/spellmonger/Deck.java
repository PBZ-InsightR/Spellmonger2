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
        this.nombreDeCartes = nombreDeCartes;
        cardPool = new ArrayList<>(nombreDeCartes);
    }

    // Initialisation aléatoire du deck
    public List<Card> InitDeck() {
        Card carte;
        for (int i = 0; i < 70; i++) {
            nbRand = rand.nextInt(6 - 1 + 1) + 1;
            if (nbRand == 1) {
                carte = new Card("", "Ritual");
                cardPool.add(carte);
            } else {
                carte = new Card("", "Creature");
                cardPool.add(carte);
            }
        }
        return cardPool;
    }

    public void AjouterCard(Card carte) {
        cardPool.add(carte);
    }

    public void RetirerCard(Card carte) {
        cardPool.remove(carte);
    }

    //La méthode retourne la dernière carte du paquet
    public Card drawCard() {
        int i = 0;
        while (!cardPool.isEmpty()) {
            i++;
        }
        return cardPool.get(i);

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
