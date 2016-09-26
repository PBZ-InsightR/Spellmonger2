package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    //Instancier Dec;
    //Instancier Plateau
    public Player p1;
    public Player p2;

    public SpellmongerApp(String name1, String name2, int lifePoints) {
        this.p1=new Player(name1,lifePoints);
        this.p2=new Player(name2,lifePoints);
        //Initialiser plateau
        //initialiser deck
    }

    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp("Alice","Bob",20);

        Player currentPlayer = app.p1;
        Player opponent=app.p2;
        int roundCounter = 1;
        String winner="";

        while(app.p1.IsAlive()==true || app.p2.IsAlive()==true){
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);


            logger.info(currentPlayer.toString()+opponent.toString());
            //Tirer une carte du deck du joueur courant
            //Appliquer dégats

            if (currentPlayer.IsAlive()==false) {
                winner = opponent.GetName();
            }
            if (opponent.IsAlive()==false) {
                winner = currentPlayer.GetName();
            }

            Player temp =currentPlayer;
            currentPlayer=opponent;
            opponent=currentPlayer;
            roundCounter++;
        }

        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + winner + " !!!");
        logger.info("******************************");


    }
}
