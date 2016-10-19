package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class EnchantmentTest {

    @Test
    public void vaultOverburn() throws Exception {
            Enchantment e1 = new Enchantment("Vault overclocking");
	    e1.VaultOverburn();
	    //Assert.assertEquals(true, e1.VaultOverburn() );

    }
			            
				        
    @Test
    public final void testEnchantmentGetName() {
        Enchantment e = new Enchantment("Vault overclocking");
        assertEquals("Vault overclocking", e.getName());
    }

    @Test
    public final void testEnchantmentGetDamage() {
        Enchantment e = new Enchantment("Vault overclocking");
        assertEquals(0.0, e.getDamage(), 0.01);
    }

    @Test
    public final void testEnchantmentGetEnergy() {
        Enchantment e = new Enchantment("Vault overclocking");
        assertEquals(1.0, e.getEnergy(), 0.01);
    }

    @Test
    public final void testEnchantmentGetEnergyCost() {
        Enchantment e = new Enchantment("Vault overclocking");
        assertEquals(3.0, e.getEnergyCost(), 0.01);
    }

}

