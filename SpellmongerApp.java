package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    //instance decks
    static Deck d1=new Deck();
    static Deck d2=new Deck();
    static List<String> deck1 = new ArrayList<>(70);
    static List<String> deck2 = new ArrayList<>(70);

    public static Player p1;
    public static Player p2;

    //Instancier Plateau

    public SpellmongerApp(String name1, String name2, int lifePoints) {
        this.p1=new Player(name1,lifePoints);
        this.p2=new Player(name2,lifePoints);

        //initialise decks
        deck1=d1.InitDeck();
        deck2=d2.InitDeck();

        //Initialiser plateau
    }

    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp("Alice","Bob",20);

        Player currentPlayer = app.p1;
        Player opponent=app.p2;
        int roundCounter = 1;
        String winner="";
        int currentCardNumber = 0;
        String card="";

        while((app.p1.IsAlive()==true || app.p2.IsAlive()==true) && 70>currentCardNumber && 70>currentCardNumber){
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);


            logger.info(currentPlayer.toString()+" "+opponent.toString());

            //Tirer une carte du deck du joueur courant
            if(currentPlayer.GetName().equals(p1.GetName()))
            {
                card=d1.drawCard(currentCardNumber,app.deck1);
            }
            else
            {
                card=d2.drawCard(currentCardNumber,app.deck2);
            }
            logger.info("Le joueur "+currentPlayer.GetName()+" pioche la carte "+card);

            //Appliquer dégats

            if (currentPlayer.IsAlive()==false) {
                winner = opponent.GetName();
            }
            if (opponent.IsAlive()==false) {
                winner = currentPlayer.GetName();
            }

            Player temp =currentPlayer;
            currentPlayer=opponent;
            opponent=temp;
            roundCounter++;
            currentCardNumber++;
        }

        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + winner + " !!!");
        logger.info("******************************");


    }
}
