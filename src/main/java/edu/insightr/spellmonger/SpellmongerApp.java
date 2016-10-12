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
    private Deck pioche;
    private Deck fausse;

    public SpellmongerApp(String name1, String name2, int lifePoints) {
        this.p1 = new Player(name1, lifePoints);
        this.p2 = new Player(name2, lifePoints);
        //Initialiser plateau
        //initialiser deck
        pioche = new Deck(70);
        fausse = new Deck(0);

    }

    public static void main(String[] args) {
        Plateau p=new Plateau("Alice","Bob",20);
        p.Jeu();
        /*SpellmongerApp app = new SpellmongerApp("Alice", "Bob", 20);
        app.pioche.InitDeck();
        app.p1.getPioche().InitDeck();
        app.p2.getPioche().InitDeck();
        Player currentPlayer = app.p1;
        Player opponent = app.p2;
        int roundCounter = 1;
        String winner = "";

        while (app.p1.IsAlive() == true && app.p2.IsAlive() == true) {
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);


            logger.info(currentPlayer.toString() + " et " + opponent.toString());
            //Tirer une carte du deck du joueur courant
            Card currentCard = currentPlayer.getPioche().drawCard();
            if (currentCard.IsCreature() == true) {
                logger.info("Le joueur pioche la carte " + currentCard.GetCreature().GetName());
                //Appliquer dégats
                if (opponent.GetListeCreature().size() != 0) {
                    //on applique les damages a la derniere carte de l'opponent
                    opponent.GetListeCreature().get(opponent.GetListeCreature().size() - 1).AlterePV(currentCard.GetCreature().GetDamage());
                    //si la creature de l'adversaire est morte on la supprime
                    if (!opponent.GetListeCreature().get(opponent.GetListeCreature().size() - 1).IsAlive()) {
                        opponent.GetListeCreature().remove(opponent.GetListeCreature().size() - 1);
                    }
                    //on ajoute la creature piocher a la liste de cartes du current player
                    currentPlayer.GetListeCreature().add(currentCard.GetCreature());

                } else {
                    opponent.AltererHP(currentCard.GetCreature().GetDamage());
                    //on ajoute la creature piocher a la liste de cartes du current player
                    currentPlayer.GetListeCreature().add(currentCard.GetCreature());
                }
            } else if (currentCard.IsCreature() == false) {
                logger.info(currentPlayer.GetName() + " pioche la carte " + currentCard.GetRitual().GetName());
                if (opponent.GetListeCreature().size() != 0) {

                    //on applique les damages a la derniere carte de l'opponent
                    opponent.GetListeCreature().get(opponent.GetListeCreature().size() - 1).AlterePV(currentCard.GetRitual().GetDamage());
                    //si la creature de l'adversaire est morte on la supprime
                    if (!opponent.GetListeCreature().get(opponent.GetListeCreature().size() - 1).IsAlive()) {
                        opponent.GetListeCreature().remove(opponent.GetListeCreature().size() - 1);
                    }
                } else {
                    opponent.AltererHP(currentCard.GetRitual().GetDamage());
                }

            }

            app.pioche.RetirerCard(currentCard);
            app.fausse.AjouterCard(currentCard);


            if (currentPlayer.IsAlive() == false) {
                winner = opponent.GetName();
            }
            if (opponent.IsAlive() == false) {
                winner = currentPlayer.GetName();
            }

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
            roundCounter++;
        }

        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + winner + " !!!");
        logger.info("******************************");
*/

    }
}
