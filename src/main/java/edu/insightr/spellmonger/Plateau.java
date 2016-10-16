package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

public class Plateau {
    private Player current, opponent;
    private int nbTours;
    private String winner;
    private static final Logger logger = Logger.getLogger(Plateau.class);

    public Plateau(String name1, String name2, int lifePoints, int energy) {
        this.current = new Player(name1, lifePoints, energy);
        this.opponent = new Player(name2, lifePoints, energy);
        nbTours = 1;
        this.current.getPioche().initDeck();
        this.opponent.getPioche().initDeck();
    }

    public int getNbTours() {
        return nbTours;
    }

    public Player getCurrent() {
        return current;
    }

    public String getWinner() {
        return winner;
    }

    public void ajouterTour() {
        this.nbTours++;
    }

    public void changeCurrent() {
        Player temp = current;
        current = opponent;
        opponent = temp;
    }

    public boolean isThereAWinner() {
        boolean isThereAWinner = false;
        if (!current.isAlive()) {
            winner = opponent.getName();
            isThereAWinner = true;
        }
        if (!opponent.isAlive()) {
            winner = current.getName();
            isThereAWinner = true;
        }
        if (current.getPioche().isEmpty()) {
            winner = "Match nul";
            isThereAWinner = true;
        }
        return isThereAWinner;
    }



    public void Jeu() {

         /*if(!isThereAWinner()) {
            logger.info("\n");
            logger.info("***** ROUND " + nbTours);

            current.addEnergy(-1);
            logger.info(current.toString() + " et " + opponent.toString());
            //Tirer une carte du deck du joueur courant
            Card currentCard = current.getPioche().drawCard();
            if (currentCard.IsCreature() == true) {
                logger.info("Le joueur pioche la carte " + currentCard.GetCreature().getName());
                //Appliquer dégats
                if (opponent.getListeCreature().size() != 0) {
                    //on applique les damages a la derniere carte de l'opponent
                    opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(currentCard.GetCreature().GetDamage());
                    logger.info("1");
                    //si la creature de l'adversaire est morte on la supprime
                    if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                        opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                    }
                    //on ajoute la creature piocher a la liste de cartes du current player
                    current.getListeCreature().add(currentCard.GetCreature());

                } else {
                    logger.info("2");
                    opponent.altererHP(currentCard.GetCreature().GetDamage());
                    current.getListeCreature().add(currentCard.GetCreature());
                }
            } else if (currentCard.IsCreature() == false) {
                logger.info(current.getName() + " pioche la carte " + currentCard.GetRitual().getName());
                if(currentCard.GetRitual().getName()=="Blessing")
                {
                    current.altererHP(currentCard.GetRitual().GetDamage());
                }
                else {
                    opponent.altererHP(currentCard.GetRitual().GetDamage());
                }
            }

            current.getPioche().retirerCard(currentCard);
            current.getFausse().ajouterCard(currentCard);

            changeCurrent();
            ajouterTour();
        }
        else{
            logger.info("\n");
            logger.info("******************************");
            logger.info("THE WINNER IS " + getWinner() + " !!!");
            logger.info("******************************");
        }
    }*/

        if (!isThereAWinner()) {
            logger.info("\n");
            logger.info("***** ROUND " + nbTours);

            current.removeEnergy(-1);
            logger.info(current.toString() + " et " + opponent.toString());
            //Tirer une carte du deck du joueur courant
            Card currentCard = current.getPioche().drawCard();
            //On crée une créature ou un rituel par rapport a la carte tirée
            logger.info("Le joueur pioche la carte " + currentCard.getName());
            //Appliquer dégats
            int indexCreature = 0;
            //on ajoute la creature piochée a la liste de cartes du current player
            current.getListeCreature().add(currentCard.GetCreature());
            //On parcourt toutes les créatures de current pour qu'elles attaquent chacune leur tours les créatures de l'adversaire
            while (opponent.getListeCreature().size() != 0 && indexCreature < current.getListeCreature().size()) {
                //on applique les damages a la derniere carte de l'opponent
                opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(current.getListeCreature().get(indexCreature).getDamage());
                //si la creature de l'adversaire est morte on la supprime
                if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                    opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                }

                indexCreature++;
            }
            //On parcourt toutes les créatures de current pour qu'elles attaquent
            while(opponent.getListeCreature().size()==0 && indexCreature < current.getListeCreature().size()) {
                opponent.altererHP(currentCard.GetCreature().GetDamage());
            }

        current.getPioche().retirerCard(currentCard);
        current.getFausse().ajouterCard(currentCard);

        changeCurrent();
        ajouterTour();
    }
        else

    {
        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + getWinner() + " !!!");
        logger.info("******************************");
    }
}
}
