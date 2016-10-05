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
    private int nbRand = 0;

    public Deck() {

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
        discard.add(carte);
    }

    public void RetirerCard(Card carte) {
        discard.remove(carte);
    }

    // Retourne objet carte contenant son nom, son type et ses dégâts
    public Card drawCard(int currentCardNumber, List<Card> deck) {
        Card carte = new Card("", "");

        if ("Creature".equalsIgnoreCase(deck.get(currentCardNumber).getType())) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0) {
                carte = new Card("Eagle", "Creature");
            } else if (randNb == 1) {
                carte = new Card("Wolf", "Creature");
            } else if (randNb == 2) {
                carte = new Card("Bear", "Creature");
            }
        } else if ("Ritual".equalsIgnoreCase(deck.get(currentCardNumber).getType())) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0) {
                carte = new Card("Curse", "Ritual");
            } else if (randNb == 1) {
                carte = new Card("Blessing", "Ritual");
            } else if (randNb == 2) {
                carte = new Card("Energy drain", "Ritual");
            }

        }
        return carte;
    }
}
