package edu.insightr.spellmonger;

import org.apache.log4j.Logger;
import java.util.Random;
import java.util.Scanner;

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

    public void InitMain()
    {
        Card carte;
        for (int i = 0; i < 3; i++) {
            int nbRand;
            Random rand = new Random();
            nbRand = rand.nextInt(8);
            switch (nbRand) {
                case 0:
                    carte = new Ritual("Curse");
                    current.getMain().add(carte);
                    break;
                case 1:
                    carte = new Ritual("Blessing");
                    current.getMain().add(carte);
                    break;
                case 2:
                    carte = new Ritual("Energy drain");
                    current.getMain().add(carte);
                    break;
                case 3:
                    carte = new Creature("Bear");
                    current.getMain().add(carte);
                    break;
                case 4:
                    carte = new Creature("Wolf");
                    current.getMain().add(carte);
                    break;
                case 5:
                    carte = new Creature("Eagle");
                    current.getMain().add(carte);
                    break;
                case 6:
                    carte = new Creature("Fox");
                    current.getMain().add(carte);
                    break;
                case 7:
                    carte = new Enchantment("Vault overclocking");
                    current.getMain().add(carte);
            }
        }
    }

    public void Pioche()
    {
        Card currentCard = current.getPioche().drawCard();
        current.getMain().add(currentCard);
    }

    public Card ChoixCarte()
    {
        Scanner sc = new Scanner(System.in);
        int tailleMain = current.getMain().size();
        logger.info("Quelle carte jouer ?");
        for (int i=0;i<tailleMain;i++)
        {
            logger.info(i + ". " + current.getMain().get(i));
        }
        int str = sc.nextInt();
        Card carteChoisi= current.getMain().get(str);
        current.getMain().remove(str);
        return carteChoisi;
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

    public void printWinner() {
        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + getWinner() + " !!!");
        logger.info("******************************");
    }


    public void bataille(Card carteChoisi) {


        Card currentCard = carteChoisi;
        logger.info("\n");
        logger.info("***** ROUND " + nbTours);
        logger.info(current.toString() + " et " + opponent.toString());
        logger.info("Le joueur " + current.getName() + " pioche la carte " + currentCard.getName());
        logger.info("Liste des créatures:");
        for (Creature c : current.getListeCreature()) {
            logger.info(c.getName());
        }
        if (current.getListeCreature().isEmpty() && opponent.getListeCreature().isEmpty()) {
            opponent.altererHP(currentCard.getDamage());
            logger.info("les damages sont " + currentCard.getDamage());
            if (currentCard instanceof Creature) {
                Creature currentCreature = (Creature) currentCard;
                //on ajoute la creature piochée a la liste de cartes du current player
                current.getListeCreature().add(currentCreature);

            }
            if (currentCard instanceof Ritual) {
                if (currentCard.getName().equals("Blessing")) {
                    current.altererHP(currentCard.getDamage());
                } else {
                    opponent.altererHP(currentCard.getDamage());
                }

            }
        } else if (current.getListeCreature().isEmpty() && !opponent.getListeCreature().isEmpty()) {
            if (currentCard instanceof Creature) {
                Creature currentCreature = (Creature) currentCard;
                //on ajoute la creature piochée a la liste de cartes du current player
                current.getListeCreature().add(currentCreature);
                opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(currentCard.getDamage());
                if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                    opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                }
                logger.info("2");
            }
            if (currentCard instanceof Ritual) {
                if (currentCard.getName().equals("Blessing")) {
                    current.altererHP(currentCard.getDamage());
                } else {
                    opponent.altererHP(currentCard.getDamage());
                }

            } else if (currentCard instanceof Enchantment) {
                Enchantment enchant = new Enchantment("Vault overclocking");
                current.removeEnergy(enchant.getEnergyCost());
            }

        } else if (!current.getListeCreature().isEmpty() && opponent.getListeCreature().isEmpty()) {
            int indexCreature = 0;
            if (currentCard instanceof Ritual) {
                if (currentCard.getName().equals("Blessing")) {
                    current.altererHP(currentCard.getDamage());
                } else {
                    opponent.altererHP(currentCard.getDamage());
                }

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
                if (currentCard.getName().equals("Blessing")) {
                    current.altererHP(currentCard.getDamage());
                } else {
                    opponent.altererHP(currentCard.getDamage());
                }

            } else if (currentCard instanceof Enchantment) {
                Enchantment enchant = new Enchantment("Vault overclocking");
                current.removeEnergy(enchant.getEnergyCost());
            } else if (currentCard instanceof Creature) {
                Creature currentCreature = (Creature) currentCard;
                //on ajoute la creature piochée a la liste de cartes du current player
                current.getListeCreature().add(currentCreature);
            }
            while (indexCreature < current.getListeCreature().size() && !opponent.getListeCreature().isEmpty()) {
                opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).alterePV(current.getListeCreature().get(indexCreature).getDamage());
                if (!opponent.getListeCreature().get(opponent.getListeCreature().size() - 1).isAlive()) {
                    opponent.getListeCreature().remove(opponent.getListeCreature().size() - 1);
                }
                indexCreature++;
            }
            if (opponent.getListeCreature().isEmpty() && indexCreature < current.getListeCreature().size() - 1) {
                while (indexCreature < current.getListeCreature().size() - 1) {
                    opponent.altererHP(current.getListeCreature().get(indexCreature).getDamage());
                    indexCreature++;
                }
            }
        }
        current.getPioche().retirerCard(currentCard);
        current.getFausse().ajouterCard(currentCard);


        changeCurrent();
        ajouterTour();


    }
    public void Jeu()
    {
        while(!isThereAWinner())
        {
            if (nbTours==1 || nbTours==2)
            {
                InitMain();
            }
            Pioche();
            Card carteChoisi = ChoixCarte();
            bataille(carteChoisi);
        }
        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + getWinner() + " !!!");
        logger.info("******************************");
    }
}



