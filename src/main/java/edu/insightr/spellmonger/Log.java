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

public class Log extends VBox {
    @FXML private Text actiontarget;
    @FXML private PasswordField passwordPF;
    @FXML private TextField usernameTF;
    @FXML private Button connectBtn;

        public Log(){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Log.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
            connectBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    if ((passwordPF.getText().equals("0000")) || (usernameTF.getCharacters().toString().equals("Karim"))) {
                        actiontarget.setText("Vous êtes connectés !!!");
                        new Game();
                    } else {
                        actiontarget.setText("Identifiants erronés !!!");
                    }

                }//end action
            });
        }






}
