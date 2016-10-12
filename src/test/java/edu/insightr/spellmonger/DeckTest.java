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
}