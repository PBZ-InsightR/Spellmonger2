package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;


public class DeckTest {
    @Test
    public void isEmpty() throws Exception {
        Deck d = new Deck(0);
        //d.initDeck();
        Assert.assertEquals(0, d.getCardPool().size());
        Assert.assertEquals(true, d.isEmpty());
        Deck d2 = new Deck(20);
        d2.initDeck();
        //Assert.assertEquals(20,d2.getCardPool().size() );
        Assert.assertEquals(false, d2.isEmpty());
    }

    @Test
    public void initDeck() throws Exception {
        Deck d = new Deck(40);
        d.initDeck();
        Assert.assertEquals(40, d.getCardPool().size());

    }

    @Test
    public void AjouterCard() throws Exception {
        Deck d = new Deck(40);
        d.initDeck();
        Card carte = new Card("Wolf");
        d.ajouterCard(carte);
        Assert.assertEquals(d.getCardPool().get(40), carte);
    }

    @Test
    public void RetirerCard() throws Exception {
        Deck d = new Deck(40);
        d.initDeck();
        Card carte = new Card("Wolf");
        d.ajouterCard(carte);
        d.retirerCard(carte);
        Assert.assertEquals(40, d.getCardPool().size());
    }

    @Test
    public void drawCard() throws Exception {
        Deck d = new Deck(40);
        d.initDeck();
        Card carte = new Card("Wolf");
        d.ajouterCard(carte);
        Assert.assertEquals(d.drawCard(), carte);
    }
}

