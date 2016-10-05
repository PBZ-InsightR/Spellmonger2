package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pierre-Marie on 05/10/2016.
 */
public class PlayerTest {
    @Test
    public void isAlive() throws Exception {
        Player p = new Player("p",0);
        Assert.assertEquals(p.IsAlive(),false);

    }

}