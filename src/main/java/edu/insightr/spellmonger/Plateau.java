package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

/**
 * Created by Karim_Utilisateur on 05/10/2016.
 */
public class Plateau {
    private Player current, opponent;
    private int nbTours;
    private String winner;
    private static final Logger logger = Logger.getLogger(Plateau.class);

    public Plateau(String name1, String name2, int lifePoints) {
        this.current = new Player(name1, lifePoints);
        this.opponent = new Player(name2, lifePoints);
        nbTours = 1;
    }

    public int getNbTours() {
        return nbTours;
    }

    public Player getCurrent() {
        return current;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void AjouterTour() {
        this.nbTours++;
    }

    public void ChangeCurrent() {
        Player temp = current;
        current = opponent;
        opponent = temp;
    }

    public boolean IsThereAWinner() {
        boolean isThereAWinner = false;
        if (current.IsAlive() == false) {
            winner = opponent.GetName();
            isThereAWinner = true;
        }
        if (opponent.IsAlive() == false) {
            winner = current.GetName();
            isThereAWinner = true;
        }
        return isThereAWinner;
    }

    public String getWinner() {
        return winner;
    }

    public void Jeu() {

        while (!IsThereAWinner()) {
            logger.info("\n");
            logger.info("***** ROUND " + nbTours);


            logger.info(current.toString() + " et " + opponent.toString());
            //Tirer une carte du deck du joueur courant
            Card currentCard = current.getPioche().drawCard();
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
                    current.GetListeCreature().add(currentCard.GetCreature());

                } else {
                    opponent.AltererHP(currentCard.GetCreature().GetDamage());
                }
            } else if (currentCard.IsCreature() == false) {
                logger.info(current.GetName() + " pioche la carte " + currentCard.GetRitual().GetName());
                /*if (opponent.GetListeCreature().size() != 0) {

                    //on applique les damages a la derniere carte de l'opponent
                    opponent.GetListeCreature().get(opponent.GetListeCreature().size() - 1).AlterePV(currentCard.GetRitual().GetDamage());
                    //si la creature de l'adversaire est morte on la supprime
                    if (!opponent.GetListeCreature().get(opponent.GetListeCreature().size() - 1).IsAlive()) {
                        opponent.GetListeCreature().remove(opponent.GetListeCreature().size() - 1);
                    }
                } else {*/
                if (currentCard.GetRitual().GetName() == "Blessing") {
                    current.AltererHP(currentCard.GetRitual().GetDamage());

                } else {
                    opponent.AltererHP(currentCard.GetRitual().GetDamage());
                }

                current.getPioche().RetirerCard(currentCard);
                current.getFausse().AjouterCard(currentCard);
            }

                ChangeCurrent();
                AjouterTour();

        }

            logger.info("\n");
            logger.info("******************************");
            logger.info("THE WINNER IS " + getWinner() + " !!!");
            logger.info("******************************");


        }
    }

