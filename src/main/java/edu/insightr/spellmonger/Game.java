package edu.insightr.spellmonger;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) {
        try{
            final URL url = getClass().getResource("/Gamefxml.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final AnchorPane root = (AnchorPane) fxmlLoader.load();
            final Scene scene = new Scene(root, 1200,600);
            primaryStage.setScene(scene);
        }catch (IOException ex){
            System.err.println("Erreur" + ex);
        }
        primaryStage.setTitle("Card Game");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private Label hpPlayer1;

    @FXML
    private void drawPlayer2(){
        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("TEST");
        alert.showAndWait();*/

    }

    @FXML
    private void drawPlayer1(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("BLABLABLA");
        alert.showAndWait();
        hpPlayer1.setText("15");
    }

}