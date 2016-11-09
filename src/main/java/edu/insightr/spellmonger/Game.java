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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Game extends Stage {


    SwitchScene application;

    public Game(SwitchScene application) {
        this.application = application;
    }

    @FXML
    private Label hpPlayer1, hpPlayer2, nomPlayer1, nomPlayer2, energyPlayer1, energyPlayer2;
    @FXML
    private Button buttonPlayer1, buttonPlayer2, buttonPasserTour;
    @FXML
    private Pane panePlayer1, panePlateau1, panePlayer2, panePlateau2;

    private Plateau plateau = new Plateau("Alice", "Bob", 20, 0);
    private int xRectPlateau1 = -150;
    private int xRectPlateau2 = -150;
    private int pos1P1 = 0;
    private int pos2P1 = 0;
    private int pos3P1 = 0;
    private int pos4P1 = 0;
    private int pos5P1 = 0;
    private int pos1P2 = 0;
    private int pos2P2 = 0;
    private int pos3P2 = 0;
    private int pos4P2 = 0;
    private int pos5P2 = 0;
    private Image img = new Image("/carte.jpg");

    @FXML
    private void drawPlayer1() {
        Card carteChoosen = new Card("Wolf");
        plateau.bataille(carteChoosen);
        hpPlayer2.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
        energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        nomPlayer1.setText("Alice");
        buttonPlayer1.setDisable(true);
        buttonPlayer2.setDisable(false);
    }

    @FXML
    private void drawPlayer2() {
        Card carteChoosen = new Card("Wolf");
        plateau.bataille(carteChoosen);
        hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        nomPlayer2.setText("Bob");
        buttonPlayer1.setDisable(false);
        buttonPlayer2.setDisable(true);
    }

    @FXML
    private void passerTour() {
        plateau.changeCurrent();
        plateau.ajouterTour();
        if (buttonPlayer1.isDisabled() == true) {
            buttonPlayer1.setDisable(false);
            buttonPlayer2.setDisable(true);
        } else {
            buttonPlayer1.setDisable(true);
            buttonPlayer2.setDisable(false);
        }
    }

    @FXML
    //lorsque l'on clique sur le bouton deck, place une carte dans la main du joueur1
    public void test1() {
        // TODO : no code duplication
        // TODO : prefer CSS for decoration
        if (pos1P1 == 0) {
            //Initialise un rectangle dans la main du joueur 1 en position 1
            Rectangle rect1P1 = new Rectangle(200, 30, 100, 100);
            rect1P1.setFill(new ImagePattern(img));
            panePlayer1.getChildren().add(rect1P1);
            pos1P1 = 1;
            rect1P1.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 1ère carte de la main du joueur 1, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau1 < 700) {
                        rect1P1.setLayoutX(xRectPlateau1);
                        rect1P1.setFill(new ImagePattern(img));
                        panePlateau1.getChildren().add(rect1P1);
                        xRectPlateau1 += 150;
                        pos1P1 = 0;
                    }
                }
            });
        } else if (pos2P1 == 0) {
            //Initialise un rectangle dans la main du joueur 1 en position 2
            Rectangle rect2P1 = new Rectangle(325, 30, 100, 100);
            rect2P1.setFill(new ImagePattern(img));
            panePlayer1.getChildren().add(rect2P1);
            pos2P1 = 1;
            rect2P1.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                ///Lorsqu'on clique sur la 2ème carte de la main du joueur 1, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau1 < 700) {
                        rect2P1.setLayoutX(xRectPlateau1 - 125);
                        rect2P1.setFill(new ImagePattern(img));
                        panePlateau1.getChildren().add(rect2P1);
                        xRectPlateau1 += 150;
                        pos2P1 = 0;
                    }
                }
            });
        } else if (pos3P1 == 0) {
            //Initialise un rectangle dans la main du joueur 1 en position 3
            Rectangle rect3P1 = new Rectangle(450, 30, 100, 100);
            rect3P1.setFill(new ImagePattern(img));
            panePlayer1.getChildren().add(rect3P1);
            pos3P1 = 1;
            rect3P1.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 3ème carte de la main du joueur 1, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau1 < 700) {
                        rect3P1.setLayoutX(xRectPlateau1 - 250);
                        rect3P1.setFill(new ImagePattern(img));
                        panePlateau1.getChildren().add(rect3P1);
                        xRectPlateau1 += 150;
                        pos3P1 = 0;
                    }
                }
            });
        } else if (pos4P1 == 0) {
            //Initialise un rectangle dans la main du joueur 1 en position 4
            Rectangle rect4P1 = new Rectangle(575, 30, 100, 100);
            rect4P1.setFill(new ImagePattern(img));
            panePlayer1.getChildren().add(rect4P1);
            pos4P1 = 1;
            rect4P1.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 4ème carte de la main du joueur 1, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau1 < 700) {
                        rect4P1.setLayoutX(xRectPlateau1 - 375);
                        rect4P1.setFill(new ImagePattern(img));
                        panePlateau1.getChildren().add(rect4P1);
                        xRectPlateau1 += 150;
                        pos4P1 = 0;
                    }
                }
            });
        } else if (pos5P1 == 0) {
            //Initialise un rectangle dans la main du joueur 1 en position 5
            Rectangle rect5P1 = new Rectangle(700, 30, 100, 100);
            rect5P1.setFill(new ImagePattern(img));
            panePlayer1.getChildren().add(rect5P1);
            pos5P1 = 1;
            rect5P1.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 5ème carte de la main du joueur 1, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau1 < 700) {
                        rect5P1.setLayoutX(xRectPlateau1 - 500);
                        rect5P1.setFill(new ImagePattern(img));
                        panePlateau1.getChildren().add(rect5P1);
                        xRectPlateau1 += 150;
                        pos5P1 = 0;
                    }
                }
            });
        }
    }

    //lorsque l'on clique sur le bouton deck, place une carte dans la main du joueur2
    @FXML
    public void test2() {
        if (pos1P2 == 0) {
            //Initialise un rectangle dans la main du joueur 2 en position 1
            Rectangle rect1P2 = new Rectangle(200, 30, 100, 100);
            rect1P2.setFill(new ImagePattern(img));
            panePlayer2.getChildren().add(rect1P2);
            pos1P2 = 1;
            rect1P2.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 1ère carte de la main du joueur 2, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau2 < 700) {
                        rect1P2.setLayoutX(xRectPlateau2);
                        rect1P2.setFill(new ImagePattern(img));
                        panePlateau2.getChildren().add(rect1P2);
                        xRectPlateau2 += 150;
                        pos1P2 = 0;
                    }
                }
            });
        } else if (pos2P2 == 0) {
            //Initialise un rectangle dans la main du joueur 2 en position 2
            Rectangle rect2P2 = new Rectangle(325, 30, 100, 100);
            rect2P2.setFill(new ImagePattern(img));
            panePlayer2.getChildren().add(rect2P2);
            pos2P2 = 1;
            rect2P2.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 2ème carte de la main du joueur 2, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau2 < 700) {
                        rect2P2.setLayoutX(xRectPlateau2 - 125);
                        rect2P2.setFill(new ImagePattern(img));
                        panePlateau2.getChildren().add(rect2P2);
                        xRectPlateau2 += 150;
                        pos2P2 = 0;
                    }
                }
            });
        } else if (pos3P2 == 0) {
            //Initialise un rectangle dans la main du joueur 2 en position 3
            Rectangle rect3P2 = new Rectangle(450, 30, 100, 100);
            rect3P2.setFill(new ImagePattern(img));
            panePlayer2.getChildren().add(rect3P2);
            pos3P2 = 1;
            rect3P2.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 3ème carte de la main du joueur 2, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau2 < 700) {
                        rect3P2.setLayoutX(xRectPlateau2 - 250);
                        rect3P2.setFill(new ImagePattern(img));
                        panePlateau2.getChildren().add(rect3P2);
                        xRectPlateau2 += 150;
                        pos3P2 = 0;
                    }
                }
            });
        } else if (pos4P2 == 0) {
            //Initialise un rectangle dans la main du joueur 2 en position 4
            Rectangle rect4P2 = new Rectangle(575, 30, 100, 100);
            rect4P2.setFill(new ImagePattern(img));
            panePlayer2.getChildren().add(rect4P2);
            pos4P2 = 1;
            rect4P2.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 4ème carte de la main du joueur 2, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau2 < 700) {
                        rect4P2.setLayoutX(xRectPlateau2 - 375);
                        rect4P2.setFill(new ImagePattern(img));
                        panePlateau2.getChildren().add(rect4P2);
                        xRectPlateau2 += 150;
                        pos4P2 = 0;
                    }
                }
            });
        } else if (pos5P2 == 0) {
            //Initialise un rectangle dans la main du joueur 2 en position 5
            Rectangle rect5P2 = new Rectangle(700, 30, 100, 100);
            rect5P2.setFill(new ImagePattern(img));
            panePlayer2.getChildren().add(rect5P2);
            pos5P2 = 1;
            rect5P2.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                //Lorsqu'on clique sur la 5ème carte de la main du joueur 2, l'ajoute au plateau
                public void handle(MouseEvent me) {
                    if (xRectPlateau2 < 700) {
                        rect5P2.setLayoutX(xRectPlateau2 - 500);
                        rect5P2.setFill(new ImagePattern(img));
                        panePlateau2.getChildren().add(rect5P2);
                        xRectPlateau2 += 150;
                        pos5P2 = 0;
                    }
                }
            });
        }
    }

    @FXML
    public void playCard() {
        //plateau.Jeu();
        hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        nomPlayer2.setText("Bob");
        buttonPlayer1.setDisable(false);
        buttonPlayer2.setDisable(true);
    }
}