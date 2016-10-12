package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pierre-Marie on 05/10/2016.
 */
public class DeckTest {
    @Test
    public void initDeck() throws Exception {
        Deck d=new Deck(40);

        Assert.assertEquals(40,d.getCardPool().size());
        
    }
    @Test
    public void AjouterCard() throws Exception {
       Deck d = new Deck(40);
        Deck res = new Deck(41);
        Creature creat1 = new Creature("Eagles");
        Card c1 = new Card(creat1 );

        //assertEquals(d.InitDeck().size() + 1, d.InitDeck().size());
        //assertTrue("la carte à bien été ajouté", d.AjouterCard(c1) = );
        assertEquals(d.InitDeck().size(),res.InitDeck().size());
    }

    @Test
    public void RetirerCard() throws Exception {


    }
    @Test
    public void drawCard() throws Exception {


    }

}