package edu.insightr.spellmonger;

import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;

public class TestRitual {

    @Test
    public final void testRitualGetName() {
        Ritual r = new Ritual("Curse");
        Assert.assertEquals("Curse", r.getName());
        r = new Ritual("Blessing");
        Assert.assertEquals("Blessing", r.getName());
        r = new Ritual("Energy drain");
        Assert.assertEquals("Energy drain", r.getName());
    }

    @Test
    public final void testRitualGetDamage() {
        Ritual r = new Ritual("Curse");
        Assert.assertEquals(3.0, r.getDamage(), 0.01);
        r = new Ritual("Blessing");
        Assert.assertEquals(-3.0, r.getDamage(), 0.01);
        r = new Ritual("Energy drain");
        Assert.assertEquals(2.0, r.getDamage(), 0.01);
        Assert.assertEquals(2.0, r.getDamage(), 0.01);

    }

    @Test
    public final void testRitualGetEnergy() {
        Ritual r = new Ritual("Curse");
        Assert.assertEquals(0.0, r.getEnergy(), 0.01);
        r = new Ritual("Blessing");
        Assert.assertEquals(0.0, r.getEnergy(), 0.01);
        r = new Ritual("Energy drain");
        Assert.assertEquals(0.0, r.getEnergy(), 0.01);
        Assert.assertEquals(0.0, r.getEnergy(), 0.01);

    }
}
