package edu.insightr.spellmonger;

import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;

public class TestRitual {

    /*@Test
    public void GetName() {
        Ritual r = new Ritual("Curse");
        Assert.assertEquals("Curse", r.getName());
        r = new Ritual("Blessing");
        Assert.assertEquals("Blessing", r.getName());
        r = new Ritual("Energy drain");
        Assert.assertEquals("Energy drain", r.getName());
    }

    @Test
    public void GetDamage() {
        Ritual r = new Ritual("Curse");
        Assert.assertEquals(3.0, r.getDamage(), 0.01);
        r = new Ritual("Blessing");
        Assert.assertEquals(-3.0, r.getDamage(), 0.01);
        r = new Ritual("Energy drain");
        Assert.assertEquals(2.0, r.getDamage(), 0.01);


    }

    @Test
    public void GetEnergy() {
        Ritual r = new Ritual("Curse");
        Assert.assertEquals(3.0, r.getEnergyCost(), 0.01);
        r = new Ritual("Blessing");
        Assert.assertEquals(3.0, r.getEnergyCost(), 0.01);
        r = new Ritual("Energy drain");
        Assert.assertEquals(2.0, r.getEnergyCost(), 0.01);


    }*/
    @Test
    public void GetName() {
        Ritual r = new Ritual(Rituals.CURSE);
        Assert.assertEquals("CURSE", r.getName());
        r = new Ritual(Rituals.BLESSING);
        Assert.assertEquals("BLESSING", r.getName());
        r = new Ritual(Rituals.ENERGYDRAIN);
        Assert.assertEquals("ENERGYDRAIN", r.getName());
    }

    @Test
    public void GetDamage() {
        Ritual r = new Ritual(Rituals.CURSE);
        Assert.assertEquals(0.0, r.getDamage(), 0.01);
        r = new Ritual(Rituals.BLESSING);
        Assert.assertEquals(3.0, r.getDamage(), 0.01);
        r = new Ritual(Rituals.ENERGYDRAIN);
        Assert.assertEquals(2.0, r.getDamage(), 0.01);


    }

    @Test
    public void GetEnergy() {
        Ritual r = new Ritual(Rituals.CURSE);
        Assert.assertEquals(1.0, r.getEnergyCost(), 0.01);
        r = new Ritual(Rituals.BLESSING);
        Assert.assertEquals(1.0, r.getEnergyCost(), 0.01);
        r = new Ritual(Rituals.ENERGYDRAIN);
        Assert.assertEquals(1.0, r.getEnergyCost(), 0.01);


    }
}
