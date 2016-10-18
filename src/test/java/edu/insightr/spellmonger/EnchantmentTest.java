package edu.insightr.spellmonger;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by meo-v on 19/10/2016.
 */
public class EnchantmentTest {
    @Test
    public void vaultOverburn() throws Exception {
        Enchantment e1 = new Enchantment("Vault overclocking");
        e1.VaultOverburn();
        //Assert.assertEquals(true, e1.VaultOverburn() );


    }

    @Test
    public void getName() throws Exception {
        Enchantment e1 = new Enchantment("Vault overclocking");
        Assert.assertEquals("Vault overclocking",e1.getName());

    }

    @Test
    public void getEnergy() throws Exception {
        Enchantment e1 = new Enchantment("Vault overclocking");
        Assert.assertEquals(1, e1.getEnergy());

    }

    @Test
    public void getEnergyCost() throws Exception {
        Enchantment e1 = new Enchantment("Vault overclocking");
        Assert.assertEquals(3, e1.getEnergyCost());

    }

    @Test
    public void getDamage() throws Exception {
        Enchantment e1 = new Enchantment("Vault overclocking");
        Assert.assertEquals(0, e1.getDamage());

    }


}