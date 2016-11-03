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

    @Test
    public void getDamage() throws  Exception {

        Creature eag1 = new Creature("Eagle");
        Creature w1 = new Creature("Wolf");
        Creature b1 = new Creature("Bear");

        Assert.assertEquals(3, b1.getDamage());
        Assert.assertEquals(2, w1.getDamage());
        Assert.assertEquals(1, eag1.getDamage());
    }

    @Test
    public void getName() throws  Exception {

        Creature eag1 = new Creature("Eagle");
        Assert.assertEquals("Eagle",eag1.getName() );

        Creature w1 = new Creature("Wolf");
        Assert.assertEquals("Wolf",w1.getName() );

        Creature f1 = new Creature("Fox");
        Assert.assertEquals("Fox",f1.getName() );
    }

    @Test
    public void getCapacity() throws  Exception {

        Creature eag1 = new Creature("Eagle");
        Assert.assertEquals("Flying",eag1.getCapacity() );

        Creature w1 = new Creature("Wolf");
        Assert.assertEquals("None",w1.getCapacity() );

        Creature f1 = new Creature("Fox");
        Assert.assertEquals("None",f1.getCapacity() );

        Creature b1 = new Creature("Bear");
        Assert.assertEquals("None",b1.getCapacity() );
    }

    @Test
    public void getEnergy() throws  Exception {

        Creature eag1 = new Creature("Eagle");
        Assert.assertEquals(1,eag1.getEnergy() );

        Creature w1 = new Creature("Wolf");
        Assert.assertEquals(2,w1.getEnergy() );

        Creature f1 = new Creature("Fox");
        Assert.assertEquals(1,f1.getEnergy() );

        Creature b1 = new Creature("Bear");
        Assert.assertEquals(3,b1.getEnergy() );
    }
}