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
        Creature wolf = new Creature("Wolf");

        int pv = wolf.getPV();
        int damage = wolf.GetDamage();
        pv -= damage;

        wolf.AlterePV(damage);

        Assert.assertEquals("Flying",Eagle.getCapacity());
        Assert.assertEquals(3, Bear.getPV());
        Assert.assertEquals(true,Bear.IsAlive());
        Assert.assertEquals(pv,wolf.getPV());
        //Assert.assertThat(true, is(equalTo(Bear.IsAlive())));
    }




}