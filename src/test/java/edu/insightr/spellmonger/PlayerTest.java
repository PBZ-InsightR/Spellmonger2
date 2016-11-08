package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void removeEnergy() throws Exception {

    }

    @Test
    public void isAlive() throws Exception {
        Player p = new Player("p",0,0);
        Assert.assertEquals(p.isAlive(),false);

    }
    @Test
    public void getLifePoints() throws Exception{
        Player p = new Player("p",1,0);
        Assert.assertEquals(1,p.getLifePoints());
    }

    @Test
    public void AltererHP() throws Exception{
        Player p = new Player("p",5,0);
        p.altererHP(2);
        Assert.assertEquals(3,p.getLifePoints());
    }

    @Test
    public void getName() throws Exception{
        Player p = new Player("p",1,0);
        Assert.assertEquals("p",p.getName());
    }

}