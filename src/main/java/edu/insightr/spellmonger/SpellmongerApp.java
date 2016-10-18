package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpellmongerApp {

    public SpellmongerApp(String name1, String name2, int lifePoints) {

    }

    public static void main(String[] args) {
        Plateau p = new Plateau("Alice","Bob",20,0);




        /*SpellmongerApp app = new SpellmongerApp("Alice", "Bob", 20);
        app.pioche.initDeck();

        Player currentPlayer = app.p1;
        Player opponent = app.p2;
        int roundCounter = 1;
        String winner = "";

        while (app.p1.isAlive() == true && app.p2.isAlive() == true) {
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);


            logger.info(currentPlayer.toString() + " et " + opponent.toString());
            //Tirer une carte du deck du joueur courant
            Card currentCard = app.pioche.drawCard();
            if (currentCard.IsCreature() == true) {
                logger.info("Le joueur pioche la carte " + currentCard.GetCreature().getName());
                //Appliquer dégats
                if (opponent.getListeCreature().size() != 0) {
                    //on applique les damages a la derniere carte de l'opponent
                    opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(currentCard.GetCreature().GetDamage());
                    //si la creature de l'adversaire est morte on la supprime
                    if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                        opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                    }
                    //on ajoute la creature piocher a la liste de cartes du current player
                    currentPlayer.getListeCreature().add(currentCard.GetCreature());

                } else {
                    opponent.altererHP(currentCard.GetCreature().GetDamage());
                    //on ajoute la creature piocher a la liste de cartes du current player
                    currentPlayer.getListeCreature().add(currentCard.GetCreature());
                }
            } else if (currentCard.IsCreature() == false) {
                logger.info(currentPlayer.getName() + " pioche la carte " + currentCard.GetRitual().getName());
                if (opponent.getListeCreature().size() != 0) {

                    //on applique les damages a la derniere carte de l'opponent
                    opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(currentCard.GetRitual().GetDamage());
                    //si la creature de l'adversaire est morte on la supprime
                    if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                        opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                    }
                } else {
                    opponent.altererHP(currentCard.GetRitual().GetDamage());
                }

            }

            app.pioche.retirerCard(currentCard);
            app.fausse.ajouterCard(currentCard);


            if (currentPlayer.isAlive() == false) {
                winner = opponent.getName();
            }
            if (opponent.isAlive() == false) {
                winner = currentPlayer.getName();
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
