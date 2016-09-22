package edu.insightr.spellmonger;

import java.util.Random;

/**
 * Created by Tanguy on 22/09/2016.
 */
public class Ritual {

    private String type;

    public Ritual() {
        int Min = 1;
        int Max = 3;
        Random r = new Random();
        int nb = Min + r.nextInt(Max - Min);
        if (nb == 1)
        {
            type = "curse";
        }
        else
        {
            type = "blessing";
        }
        //nb sera un entier aléatoire entre 1 et 2(Min inclus, Max exclus)
        //Cette fonction Random permets d'équilibrer les chances de piocher "curse" ou "blessing"
    }

    public String Type(){
        return type;
    }
}
