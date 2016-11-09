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
        p.Jeu();
    }
}
