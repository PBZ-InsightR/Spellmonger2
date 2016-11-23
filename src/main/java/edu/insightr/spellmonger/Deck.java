package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cardPool;
    private static Random rand;
    private int nbRand;

    public Deck(int numberCards) {
        rand = new Random();
        nbRand = 0;
        cardPool = new ArrayList<>(numberCards);
    }
    public Deck (List<Card> cardPool) {
        this.cardPool=cardPool;
    }

    public List<Card> getCardPool() {
        return cardPool;
    }

    // TODO : avoid french in code, prefer english for naming and comments
    // Initialisation aléatoire du deck
    public List<Card> initDeck() {
        Card carte;
        for (int i = 0; i < 40; i++) {
            nbRand = rand.nextInt(8);
            switch (nbRand) {
                case 0:
                    carte = new Ritual("Curse");
                    cardPool.add(carte);
                    break;
                case 1:
                    carte = new Ritual("Blessing");
                    cardPool.add(carte);
                    break;
                case 2:
                    carte = new Ritual("Energy drain");
                    cardPool.add(carte);
                    break;
                case 3:
                    carte = new Creature("Bear");
                    cardPool.add(carte);
                    break;
                case 4:
                    carte = new Creature("Wolf");
                    cardPool.add(carte);
                    break;
                case 5:
                    carte = new Creature("Eagle");
                    cardPool.add(carte);
                    break;
                case 6:
                    carte = new Creature("Fox");
                    cardPool.add(carte);
                    break;
                case 7:
                    carte = new Enchantment("Vault overclocking");
                    cardPool.add(carte);
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
