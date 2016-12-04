package edu.insightr.spellmonger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

import static org.apache.log4j.helpers.Loader.getResource;

public class SwitchScene extends Application {
    Stage login;
    Stage play;
    Stage score;

    @Override
    public void start(Stage primaryStage) throws Exception{
        startFirst();
    }

    public void startFirst() throws Exception{
        final URL url = getResource("Log.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        Log controller = new Log(this);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        login = new Stage();
        login.setTitle("Login");
        login.setScene(new Scene(root, 300, 275));
        login.show();
        controller.init();
//        System.out.println("ca marche");
    }

    public void startSecond() throws Exception{
        final URL url = getResource("Gamefxml.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        Game controller = new Game(this);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        play = new Stage();
        play.setTitle("Card Game");
        play.setScene(new Scene(root, 1200, 680));
        play.setResizable(false);
        play.sizeToScene();
        play.show();
        controller.next();
    }
    public void startThird() throws Exception{
        final URL url = getResource("Scoreboard.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scoreboard controller = new Scoreboard(this);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        score = new Stage();
        score.setTitle("Score Board");
        score.setScene(new Scene(root, 400, 400));
        score.setResizable(false);
        score.sizeToScene();
        score.show();
        controller.end();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
