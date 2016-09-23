package edu.insightr.spellmonger;


public class Ritual {
    private String typeRitual;
    private int damage;
    public Ritual(String typeRitual) {
        this.typeRitual = typeRitual;
        switch (typeRitual)
        {
            default:
                System.out.print("Ritual Unknown");
                break;
            case "Curse":
                this.damage=1;
                break;
            case "Blessing":
                this.damage=-2;
                break;

        }
    }

    public int getDamage(){
        return damage;
    }




}
