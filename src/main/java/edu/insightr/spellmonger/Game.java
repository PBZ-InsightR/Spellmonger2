package edu.insightr.spellmonger;/**
 * Created by Théo on 09/10/2016.
 */

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) {
        try{
            final URL url = getClass().getResource("/Gamefxml.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final AnchorPane root = (AnchorPane) fxmlLoader.load();
            final Scene scene = new Scene(root, 700,600);
            primaryStage.setScene(scene);
        }catch (IOException ex){
            System.err.println("Erreur" + ex);
        }
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}