package edu.insightr.spellmonger;

public class SpellmongerApp {

    public SpellmongerApp(String name1, String name2, int lifePoints) {

    }

    public static void main(String[] args) {
        Plateau p = new Plateau("Alice", "Bob", 20, 0);
        p.tourParTour();
    }
}