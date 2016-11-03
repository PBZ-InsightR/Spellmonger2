package edu.insightr.spellmonger;

public enum EnumCard {
    CURSE("Curse"),
    BLESSING("Blessing"),
    ENERFYDRAIN("Energy Drain"),
    WOLF("Wolf"),
    BEAR("Bear"),
    EAGLE("Eagle"),
    FOX("Fox"),
    VAULTO("Vault Overclocking");


    private String name = "";


    //Constructeur

    EnumCard(String name) {

        this.name = name;

    }


    public String toString() {

        return name;

    }
}
