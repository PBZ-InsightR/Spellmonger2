package edu.insightr.spellmonger;

public enum EnumCard {
    CURSE("Curse"),
    BLESSING("Blessing"),
    ENERGYDRAIN("Energy Drain"),
    WOLF("Wolf"),
    BEAR("Bear"),
    EAGLE("Eagle"),
    FOX("Fox"),
    VAULTO("Vault Overclocking"),
    NONE("None");

    // TODO : code indentation/organization problem

    private String name = "";

    EnumCard(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
