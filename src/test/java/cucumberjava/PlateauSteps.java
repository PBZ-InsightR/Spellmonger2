package cucumberjava;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.insightr.spellmonger.Plateau;

import org.junit.Assert;

/**
 * Created by Jean-Paul on 08/11/2016.
 */
public class PlateauSteps {
    private Plateau p;
    private boolean success;

    @Given("^a game exists$")
    public void a_game_exists() throws Throwable{
        p=new Plateau("p1","p2",20,0);
    }
    @When("^a player have 0 or less hp$")
    public void a_player_have_0_hp() throws Throwable{
        p.getCurrent().altererHP(21);
        success=p.isThereAWinner();

    }
    @Then("^a winner exists$")
    public void a_winner_exists() throws Throwable{
        Assert.assertTrue(success);
    }


}
