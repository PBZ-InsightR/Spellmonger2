package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cardPool;
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
        this.rand = new Random();
        this.nbRand = 0;
        this.nbCards = numberCards;
        this.cardPool = new ArrayList<>(this.nbCards);
    }

    public List<Card> getCardPool() {
        return this.cardPool;
    }

    // Initialisation aléatoire du deck
    public List<Card> initDeck() {
        List<Card> temp = new ArrayList<>(this.nbCards);
        //Ajout Creatures
        for(int i=0;i<nbEagle;i++){
            temp.add(new Creature("Eagle"));
        }
        for(int i=0;i<nbFox;i++){
            temp.add(new Creature("Fox"));
        }
        for(int i=0;i<nbWolf;i++){
            temp.add(new Creature("Wolf"));
        }
        for(int i=0;i<nbBear;i++){
            temp.add(new Creature("Bear"));
        }

        //Ajout Rituels
        for(int i=0;i<nbCurse;i++){
            temp.add(new Ritual("Curse"));
        }
        for(int i=0;i<nbEnergyDrain;i++){
            temp.add(new Ritual("Energy drain"));
        }
        for(int i=0;i<nbBlessing;i++){
            temp.add(new Ritual("Blessing"));
        }

        //Ajout Enchantment
        for(int i=0;i<nbEnchantment;i++){
            temp.add(new Enchantment("Vault Overclocking"));
        }

        this.mixDeck(temp);
        return cardPool;
    }

    private void mixDeck(List<Card> temp) {
        this.cardPool.removeAll(this.cardPool);
        int i = 0;
        while (i < 40){
            this.nbRand = rand.nextInt(40-i);
            this.cardPool.add(temp.get(this.nbRand));
            temp.remove(this.nbRand);
            i++;
        }
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
