package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    public List<Card> getCardPool() {
        return cardPool;
    }
    private List<Card> cardPool;
    private static Random rand;
    private int nbRand;

    public Deck(int nombreDeCartes) {
        rand = new Random();
        nbRand = 0;
        cardPool = new ArrayList<>(nombreDeCartes);
    }

    // Initialisation aléatoire du deck
    public List<Card> initDeck() {
        Card carte;
        for (int i = 0; i < 40; i++) {
            nbRand = rand.nextInt(6);
            switch (nbRand) {
                case 0:
                    carte = new Card("Curse");
                    cardPool.add(carte);
                    break;
                case 1:
                    carte = new Card("Blessing");
                    cardPool.add(carte);
                    break;
                case 2:
                    carte = new Card("Energy Drain");
                    cardPool.add(carte);
                    break;
                case 3:
                    carte = new Card("Bear");
                    cardPool.add(carte);
                    break;
                case 4:
                    carte = new Card("Wolf");
                    cardPool.add(carte);
                    break;
                case 5:
                    carte = new Card("Eagle");
                    cardPool.add(carte);
                    break;
            }
        }
        return cardPool;
    }

    public void ajouterCard(Card carte) {
        cardPool.add(carte);
    }

    public void retirerCard(Card carte) {
        cardPool.remove(carte);
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        if (cardPool.size() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    //La méthode retourne la dernière carte du paquet
    public Card drawCard() {
        return cardPool.get(cardPool.size() - 1);
    }
}
