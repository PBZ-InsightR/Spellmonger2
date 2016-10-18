package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

public class CreatureTest {
    @Test
    public void isAlive() throws Exception {
        Creature eagle = new Creature("Eagle");
        Assert.assertEquals(true, eagle.isAlive());
        Assert.assertEquals(1, eagle.getPV());
        eagle.alterePV(1);
        Assert.assertEquals(false, eagle.isAlive());
    }

    @Test
    public void alterePV() throws Exception {
        Creature eagle = new Creature("Eagle");
        eagle.alterePV(1);
        Assert.assertEquals(0, eagle.getPV());
    }
}