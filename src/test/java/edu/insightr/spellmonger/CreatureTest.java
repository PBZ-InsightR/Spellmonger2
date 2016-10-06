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
        Creature Bear = new Creature("Bear");
        Creature Eagle = new Creature("Eagle");

        Assert.assertEquals("Flying",Eagle.GetCapacity());
        Assert.assertEquals(3, Bear.GetPV());
        Assert.assertEquals(true,Bear.IsAlive());
    }




}