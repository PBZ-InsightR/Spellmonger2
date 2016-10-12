package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Karim_Utilisateur on 12/10/2016.
 */
public class CardTest {
    @Test
    public void isCreature() throws Exception {
        Creature wolf = new Creature("Wolf");
        Ritual curse = new Ritual("Curse");
        Card cardCreature = new Card(wolf);
        Card cardRitual = new Card(curse);

        Assert.assertTrue(cardCreature.IsCreature());
        Assert.assertFalse(cardRitual.IsCreature());
    }

}