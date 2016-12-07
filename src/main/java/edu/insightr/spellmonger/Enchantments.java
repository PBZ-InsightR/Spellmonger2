package edu.insightr.spellmonger;

public enum Enchantments {
    VAULT_OVERCLOCKING(0, 3, 1, "/CarteEnchantment.jpeg");

    public int damage;
    public int energyCost;
    public int energy;
    public String urlPicture;

    Enchantments(int damage, int energyCost, int energy, String urlPicture) {
        this.damage = damage;
        this.energyCost = energyCost;
        this.energy = energy;
        this.urlPicture = urlPicture;
    }
}
