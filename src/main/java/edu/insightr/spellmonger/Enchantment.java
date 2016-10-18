package edu.insightr.spellmonger;

import java.util.Random;

public class Enchantment extends Card {
    private int energy;
    private int energyCost;
    private String enchantmentName;

    public Enchantment(String enchantmentName)
    {
        super(enchantmentName);
        this.enchantmentName=enchantmentName;
        if (enchantmentName.equals("Vault overclocking"))
        {
            this.energy=1;
            this.energyCost=3;
        }
    }
    public boolean VaultOverburn()
    {
        int nbRand;
        Random rand = new Random();
        nbRand = rand.nextInt(3);
        if(nbRand==0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public String getName() {return enchantmentName;}
    public int getEnergy() {
        return energy;
    }
    public int getEnergyCost() {
        return energyCost;
    }
    @Override
    public int getDamage()
    {
        int damage =0;
        if (enchantmentName.equals("Vault overclocking"))
        {
            damage = 0;
        }
        return damage;
    }

    public String toString() {
        String message = "";
        switch (enchantmentName) {
            case "Vault overclocking":
                if(VaultOverburn()==true)
                {
                    message = "Vault overburn and is empty";
                    break;
                }
                else
                {
                    message = "L'enchantement fait " + getEnergy() + " points d'énergie";
                    break;
                }
        }
        return message;
    }
}
