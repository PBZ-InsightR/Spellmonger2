package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;


public class EnchantmentTest {

    @Test
    public void vaultOverburn() throws Exception {
        Enchantment e1 = new Enchantment(Enchantments.VAULT_OVERCLOCKING);

        e1.vaultOverburn();
        //Assert.assertEquals(true, e1.VaultOverburn() );

        e1.vaultOverburn();
        //Assert.assertEquals(true, e1.vaultOverburn() );


    }

    @Test
    public final void testEnchantmentGetName() {
        Enchantment e = new Enchantment(Enchantments.VAULT_OVERCLOCKING);
        assertEquals("VAULT_OVERCLOCKING", e.getName());
    }

    @Test
    public final void testEnchantmentGetDamage() {
        Enchantment e = new Enchantment(Enchantments.VAULT_OVERCLOCKING);
        assertEquals(0.0, e.getDamage(), 0.01);
    }

    @Test
    public final void testEnchantmentGetEnergy() {
        Enchantment e = new Enchantment(Enchantments.VAULT_OVERCLOCKING);
        assertEquals(1.0, e.getEnergy(), 0.01);
    }

    @Test
    public final void testEnchantmentGetEnergyCost() {
        Enchantment e = new Enchantment(Enchantments.VAULT_OVERCLOCKING);
        assertEquals(3.0, e.getEnergyCost(), 0.01);
    }

}

