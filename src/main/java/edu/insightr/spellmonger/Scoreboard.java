package edu.insightr.spellmonger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Karim_Utilisateur on 04/12/2016.
 */
public class Scoreboard extends Stage {
    SwitchScene application;
    @FXML
    public Button btn3;
    public void end(){
        btn3.setOnAction(event -> {
            application.score.hide();
        });
    }

    public Scoreboard(SwitchScene application) {
        this.application = application;
    }
}
