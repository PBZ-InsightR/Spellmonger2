package edu.insightr.spellmonger;

import java.util.Random;

public class Enchantment extends Card {
    // TODO : have a look on warnings !!!
    private int energy;

    public Enchantment(Enchantments init) {
        super(init.name(), init.energyCost, init.damage, init.urlPicture);
        this.energy = init.energy;
    }

    public boolean vaultOverburn() {
        int nbRand;
        Random rand = new Random();
        nbRand = rand.nextInt(3);
        if (nbRand == 0) return true;
        return false;
    }

    public int getEnergy() {
        return energy;
    }

    public String toString() {
        String message = "";
        if (vaultOverburn()) message = "Vault overburn and is empty";
        else message = "L'enchantement fait " + getEnergy() + " points d'énergie";
        return message;
    }
}
