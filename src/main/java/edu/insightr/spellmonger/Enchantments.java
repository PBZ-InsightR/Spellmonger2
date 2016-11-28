package edu.insightr.spellmonger;

public enum Enchantments {
    VAULT_OVERCLOCKING(0, 3, 1);

    public int damage;
    public int energyCost;
    public int energy;

    Enchantments(  int damage, int energyCost, int energy){
        this.damage = damage;
        this.energyCost = energyCost;
        this.energy = energy;
    }
}
