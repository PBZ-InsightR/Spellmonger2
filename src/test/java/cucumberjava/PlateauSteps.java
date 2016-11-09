package cucumberjava;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.insightr.spellmonger.Card;
import edu.insightr.spellmonger.Creature;
import edu.insightr.spellmonger.Plateau;

import org.junit.Assert;

/**
 * Created by Jean-Paul on 08/11/2016.
 */
public class PlateauSteps {
    private Plateau p;
    private boolean success;
    private int tour;
    private int tourSuivant;
    private int nombreDeCartes;
    private Card cardChoosen;
    private int p2Hp;


    @Given("^a game exists$")
    public void a_game_exists() throws Throwable {
        p = new Plateau("p1", "p2", 20, 0);
    }

    @Given("^current hand is empty$")
    public void current_hand_is_empty() throws Throwable {
        Assert.assertTrue(p.getCurrent().getMain().isEmpty());
    }

    @Given("^p1 board is empty$")
    public void p1_board_is_empty() throws Throwable {
        if (!p.getCurrent().getName().equals("p1")) {
            p.changeCurrent();
        }

        Assert.assertTrue(p.getCurrent().getListeCreature().isEmpty());

    }

    @Given("^p2 board is empty$")
    public void p2_board_is_empty() throws Throwable {
        if (!p.getCurrent().getName().equals("p2")) {
            p.changeCurrent();
        }

        Assert.assertTrue(p.getCurrent().getListeCreature().isEmpty());

    }

    @Given("^p1 cardChoosen is a bear$")
    public void p1_cardChoosen_is_a_bear() throws Throwable {
        cardChoosen = new Creature("Bear");
    }

    @When("^InitMain is called$")
    public void InitMain_is_called() throws Throwable {
        p.InitMain();
    }

    @When("^Pioche is called$")
    public void Pioche_is_called() throws Throwable {
        nombreDeCartes = p.getCurrent().getMain().size();
        p.Pioche();
    }

    @When("^a player have 0 or less hp$")
    public void a_player_have_0_hp() throws Throwable {
        p.getCurrent().altererHP(21);
        success = p.isThereAWinner();
    }

    @When("^a turn end$")
    public void a_turn_end() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        tour = p.getNbTours();
        p.ajouterTour();
        tourSuivant = p.getNbTours();
    }

    @When("^p1 beat p2$")
    public void p1_beat_p2() throws Throwable {
        p.changeCurrent();
        p.getCurrent().altererHP(21);
    }

    @When("^bataille is called$")
    public void bataille_is_called() throws Throwable {
        if (!p.getCurrent().getName().equals("p1")) {
            p.changeCurrent();
        }
        p2Hp = p.getOpponent().getLifePoints();
        p.bataille(cardChoosen);
    }

    @Then("^current hand is composed of 3 cards$")
    public void current_hand_is_composed_of_3_cards() throws Throwable {
        Assert.assertTrue(p.getCurrent().getMain().size() == 3);
    }

    @Then("^the card is add in current hand$")
    public void the_card_is_add_in_current_hand() throws Throwable {
        Assert.assertTrue(nombreDeCartes + 1 == p.getCurrent().getMain().size());
    }

    @Then("^a winner exists$")
    public void a_winner_exists() throws Throwable {
        Assert.assertTrue(success);
    }

    @Then("^the number of turns increase by 1$")
    public void the_number_of_turns_increase_by_1() throws Throwable {
        Assert.assertTrue(tour + 1 == tourSuivant);
    }

    @Then("^getCurrent return the current player$")
    public void getCurrent_return_the_current_player() throws Throwable {
        p.getCurrent().getName().equals("p1");
    }

    @Then("^getWinner return the name of the player winning$")
    public void getWinner_return_the_name_of_the_player_winning() throws Throwable {
        p.isThereAWinner();
        Assert.assertTrue(p.getWinner().equals("p1"));
    }

    @Then("^p2 loose 3 hp$")
    public void p2_loose_3_hp() throws Throwable {
        if (!p.getCurrent().getName().equals("p2")) {
            p.changeCurrent();
        }

        Assert.assertTrue(p2Hp - 3 == p.getCurrent().getLifePoints());
    }

}
