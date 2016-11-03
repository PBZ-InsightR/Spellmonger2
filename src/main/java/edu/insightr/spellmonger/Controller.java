package edu.insightr.spellmonger;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Karim_Utilisateur on 01/11/2016.
 */
public class Controller extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    new Log();
    }
}
