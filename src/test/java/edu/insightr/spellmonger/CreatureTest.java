package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

public class CreatureTest {
    @Test
    public void isAlive() throws Exception {
        Creature eagle = new Creature(EnumCard.EAGLE);
        Assert.assertEquals(true, eagle.isAlive());
        Assert.assertEquals(1, eagle.getPV());
        eagle.alterePV(1);
        Assert.assertEquals(false, eagle.isAlive());
    }

    @Test
    public void alterePV() throws Exception {
        Creature eagle = new Creature(EnumCard.EAGLE);
        eagle.alterePV(1);
        Assert.assertEquals(0, eagle.getPV());
    }

    @Test
    public void getDamage() throws Exception {

        Creature eag1 = new Creature(EnumCard.EAGLE);
        Creature w1 = new Creature(EnumCard.WOLF);
        Creature b1 = new Creature(EnumCard.BEAR);

        Assert.assertEquals(3, b1.getDamage());
        Assert.assertEquals(2, w1.getDamage());
        Assert.assertEquals(1, eag1.getDamage());
    }

    @Test
    public void getName() throws Exception {

        Creature eag1 = new Creature(EnumCard.EAGLE);
        Assert.assertEquals("Eagle", eag1.getName());

        Creature w1 = new Creature(EnumCard.WOLF);
        Assert.assertEquals("Wolf", w1.getName());

        Creature f1 = new Creature(EnumCard.FOX);
        Assert.assertEquals("Fox", f1.getName());
    }

    @Test
    public void getCapacity() throws Exception {

        Creature eag1 = new Creature(EnumCard.EAGLE);
        Assert.assertEquals("Flying", eag1.getCapacity());

        Creature w1 = new Creature(EnumCard.WOLF);
        Assert.assertEquals("None", w1.getCapacity());

        Creature f1 = new Creature(EnumCard.FOX);
        Assert.assertEquals("None", f1.getCapacity());

        Creature b1 = new Creature(EnumCard.BEAR);
        Assert.assertEquals("None", b1.getCapacity());
    }

    @Test
    public void getEnergy() throws Exception {

        Creature eag1 = new Creature(EnumCard.EAGLE);
        Assert.assertEquals(1.0, eag1.getEnergyCost(), 0.1);

        Creature w1 = new Creature(EnumCard.WOLF);
        Assert.assertEquals(2.0, w1.getEnergyCost(), 0.1);

        Creature f1 = new Creature(EnumCard.FOX);
        Assert.assertEquals(1.0, f1.getEnergyCost(), 0.1);

        Creature b1 = new Creature(EnumCard.BEAR);
        Assert.assertEquals(3.0, b1.getEnergyCost(), 0.1);
    }
}