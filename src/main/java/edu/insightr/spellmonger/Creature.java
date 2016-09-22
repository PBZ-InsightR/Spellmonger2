package edu.insightr.spellmonger;

import java.util.Random;

/**
 * Created by Tanguy on 22/09/2016.
 */
public class Creature {

    private String name;
    private int damage;

    public Creature() {

        int Min = 1;
        int Max = 4;
        Random r = new Random();
        int nb = Min + r.nextInt(Max - Min);
        if (nb == 1)
        {
            name = "Eagle";
        }
        else if(nb == 2)
        {
            name = "Wolf";
        }
        else if(nb == 3)
        {
            name = "Bear";
        }
        //nb sera un entier aléatoire entre 1 et 3 (Min inclus, Max exclus)
        //Cette fonction Random permets d'équilibrer les chances de piocher chaque Creature


        if (name == "Eagle") {
            damage = 1;
        } else if (name == "Wolf") {
            damage = 2;
        } else if (name == "Bear") {
            damage = 3;
        }
    }
    public String Name()
    {
        return name;
    }
    public int Damage()
    {
        return damage;
    }
}
