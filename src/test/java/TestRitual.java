/**
 * Created by Jean-Paul on 26/09/2016.
 */
import static org.junit.Assert.*;



import edu.insightr.spellmonger.Ritual;
import org.junit.Test;
public class TestRitual {

    @Test
    public final void testRitualGetDamage()
    {
        Ritual r=new Ritual("Curse");
        int a=3;
        if(r.getDamage()!=a)
        {
            fail("Curse getDamage fait pas 3 !");
        }
        r=new Ritual("Blessing");
        a=-3;
        if(r.getDamage()!=a)
        {
            fail("Blessing getDamage fait pas -3 !");
        }
        r=new Ritual("Energy drain");
        a=0;
        if(r.getDamage()!=a)
        {
            fail("Energy drain getDamage fait pas 0 !");
        }

    }
}
