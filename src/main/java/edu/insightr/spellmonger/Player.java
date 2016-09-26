package edu.insightr.spellmonger;

/**
 * Created by Nass on 26/09/2016.
 */
public class Player {
    private String name;
    private int lifePoints;

    public Player(String name, int lifePoints){
        this.name=name;
        this.lifePoints=lifePoints;
    }

    public String GetName(){
        return this.name;
    }
    public int GetLifePoints(){
        return this.lifePoints;
    }

    public boolean IsAlive(){
        boolean isAlive;
        if(this.lifePoints<0){
            isAlive=false;
        }
        else{
            isAlive=true;
        }
        return isAlive;
    }
}
