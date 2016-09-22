package edu.insightr.spellmonger;

public class Creature {
    private int damage;
    private String typeCreature;
    public Creature(String typeCreature){
        this.typeCreature = typeCreature;

        switch (typeCreature)
        {
            default:
                System.out.print("Creature Unknown");
                break;
            case "Eagle":
                this.damage=1;
                break;
            case "Wolf":
                this.damage=2;
                break;
            case "Bear":
                this.damage=3;
                break;

        }
    }
    public int getDamage() {
        return damage;
    }
}
