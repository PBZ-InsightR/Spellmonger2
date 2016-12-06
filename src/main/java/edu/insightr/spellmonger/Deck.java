package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cardPool;
    private List<Card> discard;
    private static Random rand;
    private int nbRand;
    private int nbCards;

    final private int nbEagle = 5;
    final private int nbFox = 10;
    final private int nbWolf = 10;
    final private int nbBear = 5;

    final private int nbCurse = 3;
    final private int nbEnergyDrain = 3;
    final private int nbBlessing = 3;

    final private int nbEnchantment = 1;

    public Deck(int numberCards) {
        rand = new Random();
        nbRand = 0;
        this.nbCards = numberCards;
        cardPool = new ArrayList<>(numberCards);
        discard = new ArrayList<>(numberCards);
    }

    public Deck(List<Card> cardPool, List<Card> discard) {
        this.cardPool = cardPool;
        this.discard=discard;
    }

    public List<Card> getCardPool() {
        return cardPool;
    }

    // TODO : avoid french in code, prefer english for naming and comments
    // Initialisation aléatoire du deck
    public List<Card> initDeck() {
        List<Card> temp = new ArrayList<>(this.nbCards);

        //Ajout Creatures
        for (int i = 0; i < nbEagle; i++) {
            temp.add(new Creature(Creatures.EAGLE));
        }
        for (int i = 0; i < nbFox; i++) {
            temp.add(new Creature(Creatures.FOX));
        }
        for (int i = 0; i < nbWolf; i++) {
            temp.add(new Creature(Creatures.WOLF));
        }
        for (int i = 0; i < nbBear; i++) {
            temp.add(new Creature(Creatures.BEAR));
        }

        //Ajout Rituels
        for (int i = 0; i < nbCurse; i++) {
            temp.add(new Ritual(Rituals.CURSE));
        }
        for (int i = 0; i < nbEnergyDrain; i++) {
            temp.add(new Ritual(Rituals.ENERGYDRAIN));
        }
        for (int i = 0; i < nbBlessing; i++) {
            temp.add(new Ritual(Rituals.BLESSING));
        }

        //Ajout Enchantment
        for (int i = 0; i < nbEnchantment; i++) {
            temp.add(new Enchantment(Enchantments.VAULT_OVERCLOCKING));
        }

        this.mixDeck(temp);
        return cardPool;
    }

    private void mixDeck(List<Card> temp) {
        this.cardPool.removeAll(this.cardPool);
        int i = 0;
        while (i < 40) {
            this.nbRand = rand.nextInt(40 - i);
            this.cardPool.add(temp.get(this.nbRand));
            temp.remove(this.nbRand);
            i++;
        }
    }

    public void ajouterDiscard(Card carte)
    {
        discard.add(carte);
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
        Card a = cardPool.get(cardPool.size() - 1);
        cardPool.remove(cardPool.size() - 1);
        return a;
    }
}
