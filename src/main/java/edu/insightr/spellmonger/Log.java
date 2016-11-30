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
import java.util.Iterator;
import java.util.ListIterator;

public class Log extends Stage {

    SwitchScene application;
    JsonRead reader = new JsonRead();


    @FXML private Text actiontarget;
    @FXML private PasswordField passwordPF;
    @FXML private TextField usernameTF;
    @FXML private Button connectBtn;
    @FXML
    public Button btn;

    public Log(SwitchScene application) {
        this.application = application;
    }

    public void init(){
        btn.setOnAction(event -> {

           String tab1[] = reader.tabLog;
           String tab2[] = reader.tabMdp;

     for(int i = 0; i < tab1.length && i < tab2.length; i++){
             try {
                 if ((passwordPF.getText().equals(tab2[i])) && (usernameTF.getCharacters().toString().equals(tab1[i]))) {
                     actiontarget.setText("Vous êtes connectés !!!");
                     application.login.hide();
                     application.startSecond();
                 } else {
                     actiontarget.setText("Identifiants erronés !!!");
                 }

                 //application.play.show();
             } catch (Exception e) {
                 e.printStackTrace();
             }

     }
        });
    }

}