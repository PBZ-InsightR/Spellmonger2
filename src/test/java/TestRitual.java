/**
 * Created by Jean-Paul on 26/09/2016.
 */
import static org.junit.Assert.*;



import edu.insightr.spellmonger.Ritual;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.insightr.spellmonger.Ritual;
import org.junit.Test;

public class TestRitual {

    @Test
    public final void testRitualGetDamage() {
        Ritual r = new Ritual("Curse");
        assertEquals(3.0, r.getDamage(), 0.01);
        r = new Ritual("Blessing");
        assertEquals(-3.0, r.getDamage(), 0.01);
        r = new Ritual("Energy drain");
        assertEquals(0.0, r.getDamage(), 0.01);
    }
}


