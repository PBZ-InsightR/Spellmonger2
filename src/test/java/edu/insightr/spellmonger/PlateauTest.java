package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nass on 12/10/2016.
 */
public class PlateauTest {
    @Test
    public void getNbTours() throws Exception {

    }

    @Test
    public void getCurrent() throws Exception {

    }

    @Test
    public void getOpponent() throws Exception {

    }

    @Test
    public void ajouterTour() throws Exception {
        Plateau p = new Plateau("alice","bob",20);
        p.AjouterTour();
        Assert.assertEquals(2,p.getNbTours());
    }

    @Test
    public void changeCurrent() throws Exception {
        Plateau p = new Plateau("alice","bob",20);
        p.ChangeCurrent();
        Player bob=p.getCurrent();
        Assert.assertEquals(bob,p.getCurrent());
    }



}