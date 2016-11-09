package edu.insightr.spellmonger;

/**
 * Created by Karim_Utilisateur on 01/11/2016.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Log extends Stage {
    SwitchScene application;
    @FXML
    public Button btn;

    public Log(SwitchScene application) {
        this.application = application;
    }

    public void init(){
        btn.setOnAction(event -> {
           // System.out.println("play OK");
            application.login.hide();

            try {
                application.startSecond();
                //application.play.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

}