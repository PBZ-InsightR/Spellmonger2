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
    @Test
    public void getLifePoints() throws Exception{
        Player p = new Player("p",1);
        Assert.assertEquals(1,p.GetLifePoints());
    }

    @Test
    public void altererHP() throws Exception{
        Player p = new Player("p",5);
        p.altererHP(2);
        Assert.assertEquals(3,p.GetLifePoints());
    }

}