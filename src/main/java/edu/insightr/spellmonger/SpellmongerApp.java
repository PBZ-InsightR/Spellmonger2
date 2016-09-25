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
    Map<String, Integer> playersDamage = new HashMap<>(2);
    List<String> cardPool = new ArrayList<>(70);
    List<String> discard = new ArrayList<>(70);

    public SpellmongerApp() {
        playersLifePoints.put("Alice", 20);
        playersLifePoints.put("Bob", 20);
        playersCreature.put("Alice", 0);
        playersCreature.put("Bob", 0);
        playersDamage.put("Alice", 0);
        playersDamage.put("Bob", 0);
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
        /* On créé des créatures différentes. On stock les damage associés à chaque créature (Eagle, Wolf, Bear)
        ** dans un tableau associé à chaque joueur. Ces dégats se cumulent et s'appliquent à la fin du tour
         */
        if ("Creature".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(3);
            if (randNb == 0){
                logger.info(currentPlayer + " draw an Eagle");
                Creature eagle = new Creature("Eagle");
                playersDamage.put(currentPlayer, playersDamage.get(currentPlayer) + eagle.getDamage());
                discard.add("Eagle");
            }
            if (randNb == 1){
                logger.info(currentPlayer + " draw a Wolf");
                Creature wolf = new Creature("Wolf");
                playersDamage.put(currentPlayer, playersDamage.get(currentPlayer) + wolf.getDamage());
                discard.add("Wolf");
            }
            if (randNb == 2){
                logger.info(currentPlayer + " draw a Bear");
                Creature bear = new Creature("Bear");
                playersDamage.put(currentPlayer, playersDamage.get(currentPlayer) + bear.getDamage());
                discard.add("Bear");
            }
            playersCreature.put(currentPlayer, playersCreature.get(currentPlayer).intValue() + 1);
            int nbCreatures = playersCreature.get(currentPlayer).intValue();

            if (nbCreatures > 0) {
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - playersDamage.get(currentPlayer)));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer + " attack and deal " + playersDamage.get(currentPlayer) + " damages to its opponent");
            }
        }
        if ("Ritual".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
            Random rand = new Random();
            int randNb = rand.nextInt(2);
            int nbCreatures = playersCreature.get(currentPlayer).intValue();
            if (randNb == 0) {
                logger.info(currentPlayer + " draw a Curse");
                Ritual curse = new Ritual("Curse");
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - nbCreatures - curse.getDamage()));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer + " attack and deal " + nbCreatures + " damages to its opponent");
                logger.info(currentPlayer + " cast a ritual that deals 3 damages to " + opponent);
                discard.add("Curse");
            }
            if (randNb == 1) {
                logger.info(currentPlayer + " draw a Blessing");
                Ritual blessing = new Ritual("Blessing");
                playersLifePoints.put(currentPlayer, (playersLifePoints.get(currentPlayer).intValue() - blessing.getDamage()));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer + " attack and deal " + nbCreatures + " damages to its opponent");
                logger.info(currentPlayer + " cast a ritual that heals 3 lifepoints to " + currentPlayer);
                discard.add("Blessing");
            }

        }
    }
}
