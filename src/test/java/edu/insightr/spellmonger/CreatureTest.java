package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Wahhlid on 26/09/2016.
 */
public class CreatureTest {

    @Test
    public void monTest() throws Exception {
        Creature Bear = new Creature("Bear","bear","Creature");
        Creature Eagle = new Creature("Eagle","eagle","Creature");

        Assert.assertEquals("Flying",Eagle.getCapacity());
        Assert.assertEquals(3, Bear.getPV());
        Assert.assertEquals(true,Bear.IsAlive());
    }




}