package edu.insightr.spellmonger;

import java.io.IOException;
import java.net.URL;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            final URL url = getClass().getResource("/Gamefxml.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final AnchorPane root = (AnchorPane) fxmlLoader.load();
            final Scene scene = new Scene(root, 1200, 600);
            primaryStage.setScene(scene);
        } catch (IOException ex) {
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
    private Label hpPlayer1, hpPlayer2, nomPlayer1, nomPlayer2, energyPlayer1, energyPlayer2;
    @FXML
    private Label creature1p1,creature2p1,creature3p1,creature4p1,creature5p1;
    @FXML
    private Label creature1p2,creature2p2,creature3p2,creature4p2,creature5p2;
    @FXML
    private Button buttonPlayer1, buttonPlayer2, buttonPasserTour;

    private Plateau plateau = new Plateau("Alice", "Bob", 20, 0);


    @FXML
    private void drawPlayer1() {
        Card carteChoosen=new Card("Wolf");
        plateau.bataille(carteChoosen);
        hpPlayer2.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
        energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        nomPlayer1.setText("Alice");
        buttonPlayer1.setDisable(true);
        buttonPlayer2.setDisable(false);
    }

    @FXML
    private void drawPlayer2() {
        Card carteChoosen=new Card("Wolf");
        plateau.bataille(carteChoosen);
        hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        nomPlayer2.setText("Bob");
        buttonPlayer1.setDisable(false);
        buttonPlayer2.setDisable(true);
    }

    @FXML
    private void passerTour(){
        plateau.changeCurrent();
        plateau.ajouterTour();
        if(buttonPlayer1.isDisabled() == true){
            buttonPlayer1.setDisable(false);
            buttonPlayer2.setDisable(true);
        }
        else{
            buttonPlayer1.setDisable(true);
            buttonPlayer2.setDisable(false);
        }
    }

    @FXML
    public void playCard() {
      //  plateau.Jeu();
        hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        nomPlayer2.setText("Bob");
        buttonPlayer1.setDisable(false);
        buttonPlayer2.setDisable(true);
    }


    // a tester
    @FXML
    public void playCard2() {
        final Rectangle rect = new Rectangle();
        rect.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
                energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                nomPlayer2.setText("Bob");
                buttonPlayer1.setDisable(false);
                buttonPlayer2.setDisable(true);

            }
        });

    }
}