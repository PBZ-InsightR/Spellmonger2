package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.Current;


public class PlateauTest {

    @Test
    public void isThereAWinner() throws Exception {

        String player1 = "p1";
        String player2 = "p2";
        /*Player p1 = new Player("p1",5,3);
        Player p2 = new Player("p1",5,3);*/
        Plateau plateau = new Plateau(player1, player2, 5, 3);
        plateau.isThereAWinner();


    }

    @Test
    public void jeu() throws Exception {

    }

    @Test
    public void ajouterTour() throws Exception {
        Plateau p = new Plateau("alice", "bob", 20, 0);
        p.ajouterTour();
        Assert.assertEquals(2, p.getNbTours());
    }

    @Test
    public void changeCurrent() throws Exception {
        Plateau p = new Plateau("alice", "bob", 20, 0);
        p.changeCurrent();
        Player bob = p.getCurrent();
        Assert.assertEquals(bob, p.getCurrent());
    }

    @Test
    public void getWinner() throws Exception {
        //Player p1 = new Player("p1",5,3);
        Plateau plateau = new Plateau("p1", "p2", 5, 3);

        Assert.assertEquals(null, plateau.getWinner());


    }

    @Test
    public void printWinner() throws Exception {
        Player p1 = new Player("p1", 5, 3);
        Plateau plateau = new Plateau("p1", "p2", 5, 3);
        plateau.printWinner();

    }

    @Test
    public void getNbTours() throws Exception {

    }


}