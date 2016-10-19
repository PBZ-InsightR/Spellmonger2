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



    public void Jeu() {

        while (!isThereAWinner()) {
            Card currentCard = current.getPioche().drawCard();
            logger.info("Le joueur "+current.getName()+" pioche la carte " + currentCard.getName());
            if (current.getListeCreature().isEmpty() && opponent.getListeCreature().isEmpty()) {
                opponent.altererHP(currentCard.getDamage());
                logger.info("4");
                if (currentCard instanceof Creature) {
                    Creature currentCreature = (Creature) currentCard;
                    //on ajoute la creature piochée a la liste de cartes du current player
                    current.getListeCreature().add(currentCreature);
                    logger.info("2");
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
                    opponent.getListeCreature().get(opponent.getListeCreature().size()-1).alterePV(current.getListeCreature().get(indexCreature).getDamage());
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
        printWinner();
    }

}


