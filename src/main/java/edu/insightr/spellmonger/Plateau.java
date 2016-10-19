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

    public void tour(Card currentCard) {
        if (current.getListeCreature().isEmpty() && opponent.getListeCreature().isEmpty()) {
            opponent.altererHP(currentCard.getDamage());
            if (currentCard instanceof Creature) {
                Creature currentCreature = (Creature) currentCard;
                //on ajoute la creature piochée a la liste de cartes du current player
                //logger.info("aie");
                current.getListeCreature().add(currentCreature);
            }
        } else if (!current.getListeCreature().isEmpty() && opponent.getListeCreature().isEmpty()) {
            int indexCreature = 0;
            if (currentCard instanceof Ritual) {
                opponent.altererHP(currentCard.getDamage());
            } else if (currentCard instanceof Enchantment) {
                Enchantment enchant = new Enchantment("Vault overclocking");
                current.removeEnergy(enchant.getEnergyCost());
            } else if (currentCard instanceof Creature) {
                Creature currentCreature = (Creature) currentCard;
                //on ajoute la creature piochée a la liste de cartes du current player
                current.getListeCreature().add(currentCreature);
            }
            while (indexCreature < current.getListeCreature().size()) {
                opponent.altererHP(current.getListeCreature().get(indexCreature).getDamage());
                indexCreature++;
            }
        } else {
            int indexCreature = 0;
            if (currentCard instanceof Ritual) {
                opponent.altererHP(currentCard.getDamage());
            } else if (currentCard instanceof Enchantment) {
                Enchantment enchant = new Enchantment("Vault overclocking");
                current.removeEnergy(enchant.getEnergyCost());
            } else if (currentCard instanceof Creature) {
                Creature currentCreature = (Creature) currentCard;
                //on ajoute la creature piochée a la liste de cartes du current player
                current.getListeCreature().add(currentCreature);
            }
            while (indexCreature < current.getListeCreature().size() && !opponent.getListeCreature().isEmpty()) {
                opponent.getListeCreature().get(opponent.getListeCreature().size() - indexCreature).alterePV(current.getListeCreature().get(indexCreature).getDamage());
                if (!opponent.getListeCreature().get(opponent.getListeCreature().size()).isAlive()) {
                    opponent.getListeCreature().remove(opponent.getListeCreature().size());
                }
                indexCreature++;
            }
            if (opponent.getListeCreature().isEmpty() && indexCreature < current.getListeCreature().size()) {
                while (indexCreature < current.getListeCreature().size()) {
                    opponent.altererHP(current.getListeCreature().get(indexCreature).getDamage());
                    indexCreature++;
                }
            }
        }
        current.getPioche().retirerCard(currentCard);
        current.getFausse().ajouterCard(currentCard);
        logger.info("5");

        changeCurrent();
        ajouterTour();
    }

    public void printWinner(){
        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + getWinner() + " !!!");
        logger.info("******************************");
    }
}


    /*public void Jeu() {

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
    }

        while (!isThereAWinner()) {
            logger.info("\n");
            logger.info("***** ROUND " + nbTours);

            current.removeEnergy(-1);
            logger.info(current.toString() + " et " + opponent.toString());
            //Tirer une carte du deck du joueur courant
            Card currentCard = current.getPioche().drawCard();

            logger.info("Le joueur pioche la carte " + currentCard.getName());
            //Appliquer dégats
            int indexCreature = 0;

            if (current.getListeCreature().isEmpty() && opponent.getListeCreature().isEmpty()) {
                opponent.altererHP(currentCard.getDamage());
                if (currentCard instanceof Creature) {
                    Creature currentCreature = (Creature) currentCard;
                    //on ajoute la creature piochée a la liste de cartes du current player
                    current.getListeCreature().add(currentCreature);
                    logger.info("10");

                }

            } else {
                //On parcourt toutes les créatures de current pour qu'elles attaquent chacune leur tours les créatures de l'adversaire
                while (opponent.getListeCreature().size() != 0 || indexCreature < current.getListeCreature().size() && current.getListeCreature().size() != 0) {
                    //on applique les damages a la derniere carte de l'opponent
                    opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(current.getListeCreature().get(indexCreature).getDamage());
                    //si la creature de l'adversaire est morte on la supprime
                    logger.info("2");
                    if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                        opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                        logger.info("3");
                    }
                    if (currentCard instanceof Creature) {
                        Creature currentCreature = (Creature) currentCard;
                        //on ajoute la creature piochée a la liste de cartes du current player
                        current.getListeCreature().add(currentCreature);
                        logger.info("1");
                    }
                    indexCreature++;
                }
                //On parcourt toutes les créatures de current pour qu'elles attaquent
                while (opponent.getListeCreature().size() == 0 && indexCreature < current.getListeCreature().size()) {
                    opponent.altererHP(currentCard.getDamage());

                    logger.info("4");

                }
            }

            current.getPioche().retirerCard(currentCard);
            current.getFausse().ajouterCard(currentCard);
            logger.info("5");

            changeCurrent();
            ajouterTour();
        }
        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + getWinner() + " !!!");
        logger.info("******************************");
        logger.info("6");
    }
}*/

