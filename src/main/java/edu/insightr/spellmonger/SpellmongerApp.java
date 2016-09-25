package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    Map<String, Integer> playersLifePoints = new HashMap<>(2);
    Map<String, Integer> playersCreature = new HashMap<>(2);
    List<String> cardPool = new ArrayList<>(70);
    List<String> discard = new ArrayList<>(70);
    List<Creature> creature1 = new ArrayList<>(70);
    int nbCreatures1 = 0;
    List<Creature> creature2 = new ArrayList<>(70);
    int nbCreatures2 = 0;
    int degat1=0;
    int degat2=0;
    public SpellmongerApp() {
        playersLifePoints.put("Alice", 20);
        playersLifePoints.put("Bob", 20);
        playersCreature.put("Alice", 0);
        playersCreature.put("Bob", 0);
        int ritualMod = 3;

        for (int i = 0; i < 70; i++) {
            if (i % ritualMod == 0) {
                cardPool.add("Ritual");
            }
            if (i % ritualMod != 0) {
                cardPool.add("Creature");
            }

            if (ritualMod == 3) {
                ritualMod = 2;
            } else {
                ritualMod = 3;
            }

        }
    }

    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp();

        boolean onePlayerDead = false;
        String currentPlayer = "Alice";
        String opponent = "Bob";
        int currentCardNumber = 0;
        int roundCounter = 1;
        String winner = null;

        while (!onePlayerDead) {
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);

            app.drawACard(currentPlayer, opponent, currentCardNumber);

            logger.info(opponent + " has " + app.playersLifePoints.get(opponent).intValue() + " life points and " + currentPlayer + " has " + app.playersLifePoints.get(currentPlayer).intValue() + " life points ");

            if (app.playersLifePoints.get(currentPlayer).intValue() <= 0) {
                winner = opponent;
                onePlayerDead = true;
            }
            if (app.playersLifePoints.get(opponent).intValue() <= 0) {
                winner = currentPlayer;
                onePlayerDead = true;
            }

            if ("Alice".equalsIgnoreCase(currentPlayer)) {
                currentPlayer = "Bob";
                opponent = "Alice";
            } else {
                currentPlayer = "Alice";
                opponent = "Bob";
            }
            currentCardNumber++;
            roundCounter++;
        }

        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + winner + " !!!");
        logger.info("******************************");


    }

    public void drawACard(String currentPlayer, String opponent, int currentCardNumber) {
        if (currentPlayer == "Bob") {
            if ("Creature".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
                //choisit aléatoirement le type de creature
                Random rand = new Random();
                int nombre = rand.nextInt(3);
                if (nombre == 0) {
                    logger.info(currentPlayer + " draw a Eagle");
                    Creature eagle = new Creature("Eagle");
                    creature1.add(eagle);
                    nbCreatures1++;
                    discard.add("Eagle");
                }
                if (nombre == 1) {
                    logger.info(currentPlayer + " draw a Wolf");
                    Creature wolf = new Creature("Wolf");
                    creature1.add(wolf);
                    nbCreatures1++;
                    discard.add("Wolf");
                }
                if (nombre == 2) {
                    logger.info(currentPlayer + " draw a Bear");
                    Creature bear = new Creature("Bear");
                    creature1.add(bear);
                    nbCreatures1++;
                    discard.add("Bear");
                }
                //calcul les dégats de chaque créature
                if (nbCreatures1> 0) {
                    int index;
                    degat1 = 0;
                    for (index = 0; index < nbCreatures1; index++) {
                        degat1 = degat1 + creature1.get(index).damage;
                    }
                    playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - degat1));
                    logger.info("The " + nbCreatures1 + " creatures of " + currentPlayer + " attack and deal " + degat1 + " damages to its opponent");


                }
            }
            if ("Ritual".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
                //choisit aléatoirement le rituel
                Random rand= new Random();
                int nombre = rand.nextInt(2);
                if (nombre==0) {
                    logger.info(currentPlayer + " draw a Curse");
                    logger.info(currentPlayer + " cast a curse that deals 3 damages to " + opponent);
                    playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - degat1 - 3));
                    logger.info("The " + nbCreatures1 + " creatures of " + currentPlayer + " attack and deal " + degat1 + " damages to its opponent");
                    discard.add("Curse");
                }
                if (nombre==1) {
                    logger.info(currentPlayer + " draw a Blessing");
                    logger.info(currentPlayer + " cast a blessing that heals 3 HP to " + currentPlayer);
                    playersLifePoints.put(currentPlayer, (playersLifePoints.get(currentPlayer).intValue() +3));
                    playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - degat1));
                    logger.info("The " + nbCreatures1 + " creatures of " + currentPlayer + " attack and deal " + degat1 + " damages to its opponent");
                    discard.add("Blessing");
                }

            }
        }
        if (currentPlayer == "Alice") {
            if ("Creature".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
                //choisit aléatoirement le type de creature
                Random rand = new Random();
                int nombre = rand.nextInt(3);
                if (nombre == 0) {
                    logger.info(currentPlayer + " draw a Eagle");
                    Creature eagle = new Creature("Eagle");
                    creature2.add(eagle);
                    nbCreatures2++;
                    discard.add("Eagle");
                }
                if (nombre == 1) {
                    logger.info(currentPlayer + " draw a Wolf");
                    Creature wolf = new Creature("Wolf");
                    creature2.add(wolf);
                    nbCreatures2++;
                    discard.add("Wolf");
                }
                if (nombre == 2) {
                    logger.info(currentPlayer + " draw a Bear");
                    Creature bear = new Creature("Bear");
                    creature2.add(bear);
                    nbCreatures2++;
                    discard.add("Bear");
                }
                if (nbCreatures2 > 0) {
                    //calcul les dégats de chaque créature
                    int index;
                    degat2 = 0;
                    for (index = 0; index < nbCreatures2; index++) {
                        degat2 = degat2 + creature2.get(index).damage;
                    }
                    playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - degat2));
                    logger.info("The " + nbCreatures2 + " creatures of " + currentPlayer + " attack and deal " + degat2 + " damages to its opponent");

                }
            }
            if ("Ritual".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
                //choisit aléatoirement le ritue
                Random rand= new Random();
                int nombre = rand.nextInt(2);
                if (nombre==0) {
                    logger.info(currentPlayer + " draw a Curse");
                    logger.info(currentPlayer + " cast a curse that deals 3 damages to " + opponent);
                    playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - degat2 - 3));
                    logger.info("The " + nbCreatures2 + " creatures of " + currentPlayer + " attack and deal " + degat2 + " damages to its opponent");
                    discard.add("Curse");
                }

                if (nombre==1) {
                    logger.info(currentPlayer + " draw a Blessing");
                    logger.info(currentPlayer + " cast a blessing that heals 3 HP to " + currentPlayer);
                    playersLifePoints.put(currentPlayer, (playersLifePoints.get(currentPlayer).intValue() + 3));
                    playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - degat2));
                    logger.info("The " + nbCreatures2 + " creatures of " + currentPlayer + " attack and deal " + degat2 + " damages to its opponent");
                    discard.add("Blessing");
                }
            }
        }
    }

}