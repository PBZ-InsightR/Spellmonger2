package edu.insightr.spellmonger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Scoreboard extends Stage {
    SwitchScene application;
    @FXML
    private Button btn3;

    public void end() {
        btn3.setOnAction(event -> {
            application.score.hide();
        });
    }

    public Scoreboard(SwitchScene application) {
        this.application = application;
    }
}
