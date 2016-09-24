package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static java.lang.Math.abs;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    Map<String, Integer> playersLifePoints = new HashMap<>(2);
    Map<String, Integer> playersCreature = new HashMap<>(2);
    List<String> Discard = new ArrayList<>();
    List<Creature> Creatures = new ArrayList<>();
    List<Ritual> Rituals = new ArrayList<>();
    List<String> cardPool = new ArrayList<>(70);
    static Random rand = new Random();


    public SpellmongerApp() {
        playersLifePoints.put("Alice", 20);
        playersLifePoints.put("Bob", 20);
        playersCreature.put("Alice", 0);
        playersCreature.put("Bob", 0);
        int ritualMod = 3;
        int nbRand=0;
        int nbRand2=0;
        Creature cre;
        Ritual rit;

        //Génération aléatoire des cartes
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

        //génération aléatoire des créatures
        for(int i=0;i<70;i++)
        {
            nbRand=rand.nextInt(3 - 1 + 1) +1;
            if(nbRand==1)
            {
                cre=new Creature("Eagle");
                Creatures.add(cre);
            }
            else if(nbRand==2)
            {
                cre=new Creature("Wolf");
                Creatures.add(cre);
            }
            else
            {
                cre=new Creature("Bear");
                Creatures.add(cre);
            }
        }

        //génération aléatoire des rituels
        for(int i=0;i<70;i++)
        {
            nbRand2=rand.nextInt(2 - 1 + 1) +1;
            if(nbRand2==1)
            {
                rit=new Ritual("Curse");
                Rituals.add(rit);
            }
            else
            {
                rit=new Ritual("Blessing");
                Rituals.add(rit);
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

        //si la carte est une créature
        if ("Creature".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
            logger.info(currentPlayer + " draw the Creature "+Creatures.get(currentCardNumber).NameC());
            playersCreature.put(currentPlayer, playersCreature.get(currentPlayer).intValue() + Creatures.get(currentCardNumber).Dmg());
            int nbCreatures = playersCreature.get(currentPlayer).intValue();
            if (nbCreatures > 0) {
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - nbCreatures));
                logger.info("The creatures of " + currentPlayer + " attack and deal " + nbCreatures + " damages to its opponent");
            }
            Discard.add(Creatures.get(currentCardNumber).NameC());
        }

        //si la carte est un rituel
        if ("Ritual".equalsIgnoreCase(cardPool.get(currentCardNumber))) {
            logger.info(currentPlayer + " draw the Ritual "+Rituals.get(currentCardNumber).NameR());
            int nbCreatures = playersCreature.get(currentPlayer).intValue();

            //si le rituel est "Curse"
            if("Curse".equalsIgnoreCase(Rituals.get(currentCardNumber).NameR()))
            {
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - nbCreatures - Rituals.get(currentCardNumber).Effect()));
                logger.info(currentPlayer + " cast a ritual that deals "+Rituals.get(currentCardNumber).Effect()+" damages to " + opponent);
            }

            //si le rituel est "Blessing"
            else if("Blessing".equalsIgnoreCase(Rituals.get(currentCardNumber).NameR()))
            {
                playersLifePoints.put(currentPlayer, (playersLifePoints.get(currentPlayer).intValue() - Rituals.get(currentCardNumber).Effect()));
                logger.info(currentPlayer + " cast a ritual that heals "+abs(Rituals.get(currentCardNumber).Effect())+" point to " + currentPlayer);
            }
            if (nbCreatures > 0) {
                playersLifePoints.put(opponent, (playersLifePoints.get(opponent).intValue() - nbCreatures));
                logger.info("The creatures of " + currentPlayer + " attack and deal " + nbCreatures + " damages to its opponent");
            }
            Discard.add(Rituals.get(currentCardNumber).NameR());
        }
    }

}
