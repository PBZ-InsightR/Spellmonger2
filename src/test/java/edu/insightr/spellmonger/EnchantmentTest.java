package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;


public class EnchantmentTest {

    @Test
    public void vaultOverburn() throws Exception {
        Enchantment e1 = new Enchantment(EnumCard.VAULTO);

        e1.vaultOverburn();
        //Assert.assertEquals(true, e1.VaultOverburn() );

        e1.vaultOverburn();
        //Assert.assertEquals(true, e1.vaultOverburn() );


    }

    @Test
    public final void testEnchantmentGetName() {
        Enchantment e = new Enchantment(EnumCard.VAULTO);
        assertEquals("Vault overclocking", e.getName());
    }

    @Test
    public final void testEnchantmentGetDamage() {
        Enchantment e = new Enchantment(EnumCard.VAULTO);
        assertEquals(0.0, e.getDamage(), 0.01);
    }

    @Test
    public final void testEnchantmentGetEnergy() {
        Enchantment e = new Enchantment(EnumCard.VAULTO);
        assertEquals(1.0, e.getEnergy(), 0.01);
    }

    @Test
    public final void testEnchantmentGetEnergyCost() {
        Enchantment e = new Enchantment(EnumCard.VAULTO);
        assertEquals(3.0, e.getEnergyCost(), 0.01);
    }

}

