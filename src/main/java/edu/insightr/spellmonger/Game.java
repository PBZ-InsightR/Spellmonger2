package edu.insightr.spellmonger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    @FXML
    private Label hpPlayer1, hpPlayer2, nomPlayer1, nomPlayer2, energyPlayer1, energyPlayer2;
    @FXML
    private Button buttonPlayer1, buttonPlayer2, buttonPasserTour, buttonFinish1, buttonFinish2, buttonBattle1, buttonBattle2;
    @FXML
    private Pane panePlayer1, panePlateau1, panePlayer2, panePlateau2;
    private Plateau plateau = new Plateau("Alice", "Bob", 20, 0);
    private Deck deck = new Deck(40);
    private List<Card> jeu1 = deck.initDeck();
    private List<Card> jeu2 = deck.initDeck();
    private List<Card> discard1 = deck.initDeck();
    private List<Card> discard2 = deck.initDeck();
    private Deck deck1 = new Deck(jeu1,discard1);
    private Deck deck2 = new Deck(jeu2,discard2);
    private int xRectPlateau1 = 265;
    private int xRectPlateau2 = 265;
    private double posX;
    private double posX2;
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
    private int xCarteMain1 = 0;
    private int xCarteMain2 = 0;
    private Creature currentCreature;

    public Game(SwitchScene application) {
        this.application = application;
    }

    @FXML
    public Button btn2;

    public void next() {
        btn2.setOnAction(event -> {
            application.play.hide();
            try {
                application.startThird();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private Card drawPlayer1() {
        Card carteChoosen = deck1.drawCard();
        nomPlayer1.setText("Alice");
        buttonPlayer1.setDisable(true);
        return carteChoosen;
    }

    @FXML
    private Card drawPlayer2() {
        Card carteChoosen = deck2.drawCard();
        nomPlayer2.setText("Bob");
        buttonPlayer2.setDisable(true);
        return carteChoosen;
    }

    @FXML
    //lorsque l'on clique sur le bouton deck, place une carte dans la main du joueur1 
    public void test1() {
        // TODO : prefer CSS for decoration
        if (pos1P1 == 0) {
            xCarteMain1 = 200;
            pos1P1 = 1;
        } else if (pos2P1 == 0) {
            xCarteMain1 = 325;
            pos2P1 = 1;
        } else if (pos3P1 == 0) {
            xCarteMain1 = 450;
            pos3P1 = 1;
        } else if (pos4P1 == 0) {
            xCarteMain1 = 575;
            pos4P1 = 1;
        } else if (pos5P1 == 0) {
            xCarteMain1 = 700;
            pos5P1 = 1;
        }
        Rectangle rectP1 = new Rectangle(xCarteMain1, 0, 100, 148);
        rectP1.setStroke(Color.BLACK);
        rectP1.setStrokeType(StrokeType.INSIDE);
        Card carte = drawPlayer1();
        plateau.getCurrent().addEnergy();
        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        rectP1.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
        panePlayer1.getChildren().add(rectP1);
        rectP1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            //Lorsqu'on clique sur la 1ère carte de la main du joueur 1, l'ajoute au plateau
            public void handle(MouseEvent me) {
                if((plateau.getCurrent().getEnergy() >= carte.getEnergyCost()))
                {
                    if(carte instanceof Creature)
                    {
                        Rectangle rect2P1 = new Rectangle(xRectPlateau1, 0, 100, 148);
                        if (xRectPlateau1 < 800) {
                            plateau.getCurrent().removeEnergy(carte.getEnergyCost());
                            energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                            if (carte instanceof Creature) {
                                rect2P1.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
                                currentCreature = (Creature) carte;
                                plateau.getCurrent().getListeCreature().add(currentCreature);
                            } else {
                                rect2P1.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
                            }
                            panePlateau1.getChildren().add(rect2P1);
                            xRectPlateau1 += 173;
                            nomPlayer1.setText("aaa");

                        }
                        //plateau.bataille(carte);
                        //hpPlayer2.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
                    }
                    else if((carte instanceof Ritual || carte instanceof Enchantment))
                    {
                        plateau.getCurrent().removeEnergy(carte.getEnergyCost());
                        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                        deck1.ajouterDiscard(carte);
                    }

                    posX = rectP1.getX();
                    rectP1.setWidth(0);
                    rectP1.setHeight(0);

                    if (posX == 200) {
                        pos1P1 = 0;
                    } else if (posX == 325) {
                        pos2P1 = 0;
                    } else if (posX == 450) {
                        pos3P1 = 0;
                    } else if (posX == 575) {
                        pos4P1 = 0;
                    } else if (posX == 700) {
                        pos5P1 = 0;
                    }
                }

            }
        });
    }

    //lorsque l'on clique sur le bouton deck, place une carte dans la main du joueur2
    @FXML
    public void test2() {
        if (pos1P2 == 0) {
            xCarteMain2 = 200;
            pos1P2 = 1;
        } else if (pos2P2 == 0) {
            xCarteMain2 = 325;
            pos2P2 = 1;
        } else if (pos3P2 == 0) {
            xCarteMain2 = 450;
            pos3P2 = 1;
        } else if (pos4P2 == 0) {
            xCarteMain2 = 575;
            pos4P2 = 1;
        } else if (pos5P2 == 0) {
            xCarteMain2 = 700;
            pos5P2 = 1;
        }
        Rectangle rectP2 = new Rectangle(xCarteMain2, 0, 100, 148);
        rectP2.setStroke(Color.BLACK);
        rectP2.setStrokeType(StrokeType.INSIDE);
        Card carte = drawPlayer2();
        plateau.getCurrent().addEnergy();
        energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        rectP2.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
        panePlayer2.getChildren().add(rectP2);
        //if (plateau.getCurrent().getEnergy() < carte.getEnergyCost()){
            //rectP2.setOpacity(0.5);
        //}
        rectP2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            //Lorsqu'on clique sur la 1ère carte de la main du joueur 1, l'ajoute au plateau
            public void handle(MouseEvent me) {
                if(plateau.getCurrent().getEnergy() >= carte.getEnergyCost())
                {
                    if(carte instanceof Creature)
                    {
                        Rectangle rect2P2 = new Rectangle(xRectPlateau2, 0, 100, 148);
                        if (xRectPlateau2 < 800) {
                            plateau.getCurrent().removeEnergy(carte.getEnergyCost());
                            energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                            if (carte instanceof Creature) {
                                rect2P2.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
                                currentCreature = (Creature) carte;
                                plateau.getCurrent().getListeCreature().add(currentCreature);
                            } else {
                                rect2P2.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
                            }
                            panePlateau2.getChildren().add(rect2P2);
                            xRectPlateau2 += 173;
                        }

                        // plateau.bataille(carte);
                        //hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
                    }
                    else if((carte instanceof Ritual || carte instanceof Enchantment))
                    {
                        plateau.getCurrent().removeEnergy(carte.getEnergyCost());
                        energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                        deck2.ajouterDiscard(carte);
                    }

                    posX2 = rectP2.getX();
                    rectP2.setWidth(0);
                    rectP2.setHeight(0);

                    if (posX2 == 200) {
                        pos1P2 = 0;
                    } else if (posX2 == 325) {
                        pos2P2 = 0;
                    } else if (posX2 == 450) {
                        pos3P2 = 0;
                    } else if (posX2 == 575) {
                        pos4P2 = 0;
                    } else if (posX2 == 700) {
                        pos5P2 = 0;
                    }
                }
            }
        });
    }

    @FXML
    public void finishTurn1() {
        buttonFinish1.setVisible(false);
        buttonBattle1.setVisible(false);
        buttonBattle2.setDisable(false);
        buttonPlayer1.setDisable(true);
        buttonFinish2.setVisible(true);
        buttonBattle2.setVisible(true);
        buttonPlayer2.setDisable(false);
        plateau.FinTour();
    }

    @FXML
    public void finishTurn2() {
        buttonFinish1.setVisible(true);
        buttonBattle1.setVisible(true);
        buttonBattle1.setDisable(false);
        buttonPlayer1.setDisable(false);
        buttonFinish2.setVisible(false);
        buttonBattle2.setVisible(false);
        buttonPlayer2.setDisable(true);
        plateau.FinTour();
    }

    @FXML
    public void Battle1() {
        plateau.bataille();
        hpPlayer2.setText(Integer.toString(plateau.getOpponent().getLifePoints()));
        buttonBattle1.setDisable(true);
    }

    @FXML
    public void Battle2() {
        plateau.bataille();
        hpPlayer1.setText(Integer.toString(plateau.getOpponent().getLifePoints()));
        buttonBattle2.setDisable(true);
    }
}