package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;


public class PlateauTest {
    @Test
    public void isThereAWinner() throws Exception {

    }

    @Test
    public void jeu() throws Exception {

    }

    @Test
    public void ajouterTour() throws Exception {
        Plateau p = new Plateau("alice","bob",20,0);
        p.ajouterTour();
        Assert.assertEquals(2,p.getNbTours());
    }

    @Test
    public void changeCurrent() throws Exception {
        Plateau p = new Plateau("alice","bob",20,0);
        p.changeCurrent();
        Player bob=p.getCurrent();
        Assert.assertEquals(bob,p.getCurrent());
    }



}