package edu.insightr.spellmonger;

import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;

public class TestRitual {


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
        Assert.assertEquals(3.0, r.getDamage(), 0.01);
        r = new Ritual(Rituals.BLESSING);
        Assert.assertEquals(0.0, r.getDamage(), 0.01);
        r = new Ritual(Rituals.ENERGYDRAIN);
        Assert.assertEquals(2.0, r.getDamage(), 0.01);


    }

    @Test
    public void getEnergyCost() {
        Ritual r = new Ritual(Rituals.CURSE);
        Assert.assertEquals(3.0, r.getEnergyCost(), 0.01);
        r = new Ritual(Rituals.BLESSING);
        Assert.assertEquals(3.0, r.getEnergyCost(), 0.01);
        r = new Ritual(Rituals.ENERGYDRAIN);
        Assert.assertEquals(3.0, r.getEnergyCost(), 0.01);

    }

    @Test
    public void getGain() {
        Ritual r = new Ritual(Rituals.BLESSING);
        Assert.assertEquals(3.0, r.getGain(), 0.01);
        r = new Ritual(Rituals.CURSE);
        Assert.assertEquals(0.0, r.getGain(), 0.01);
        r = new Ritual(Rituals.ENERGYDRAIN);
        Assert.assertEquals(2.0, r.getGain(), 0.01);
    }

}
