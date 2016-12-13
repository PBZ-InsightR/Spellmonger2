package edu.insightr.spellmonger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Button buttonPlayer1, buttonPlayer2, buttonPasserTour, buttonFinish1, buttonFinish2, buttonBattle1, buttonBattle2, btnStart;
    @FXML
    private Pane panePlayer1, panePlateau1, panePlayer2, panePlateau2, paneTotal;
    @FXML
    private ImageView Card1P1, Card2P1, Card3P1, Card4P1, CimetiereP1, Card1P2, Card2P2, Card3P2, Card4P2, CimetiereP2;
    private Plateau plateau = new Plateau("Alice", "Bob", 20, 0);
    private Deck deck = new Deck(40);
    private List<Card> jeu1 = deck.initDeck();
    private List<Card> jeu2 = deck.initDeck();
    private Deck deck1 = new Deck(jeu1);
    private Deck deck2 = new Deck(jeu2);
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
    public void start() {
        btnStart.setDisable(true);
        btnStart.setVisible(false);
        paneTotal.setOpacity(1);
        nomPlayer1.setText("Alice");
        nomPlayer2.setText("Bob");
        buttonBattle1.setDisable(true);
        // Make button player 2 disable
        buttonFinish2.setDisable(true);
        buttonBattle2.setDisable(true);
        buttonPlayer2.setDisable(true);
        // Make button player 2 not visable
        buttonFinish2.setVisible(false);
        buttonBattle2.setVisible(false);

        // Make button player 1 not Disable
        if(plateau.getOpponent().getListeCreature().size() > 0)buttonBattle1.setDisable(false);
        buttonFinish1.setDisable(false);
        buttonPlayer1.setDisable(false);
        // Make button player 1 visable
        buttonFinish1.setVisible(true);
        buttonBattle1.setVisible(true);

    }

    @FXML
    private Card drawPlayer() {
        Button button = null;
        if (plateau.getCurrent().getName() == nomPlayer1.getText()) {
            button = buttonPlayer1;
        }else if (plateau.getCurrent().getName() == nomPlayer2.getText()) {
            button = buttonPlayer2;
        }else {
            // !PB! nom inconnu
        }
        Deck deck = plateau.getCurrent().getPioche();
        button.setDisable(true);
        return deck.drawCard();
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
        Card carte = drawPlayer();
        for(int i=0;i<plateau.refreshEnergy();i++)
        {
            if(plateau.getCurrent().getEnergy()<plateau.refreshEnergy())
            {
                plateau.getCurrent().addEnergy();
            }
        }

        plateau.getCurrent().addEnergy();
        energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        rectP1.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
        panePlayer1.getChildren().add(rectP1);
        rectP1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            //Lorsqu'on clique sur la 1ère carte de la main du joueur 1, l'ajoute au plateau
            public void handle(MouseEvent me) {
                if (plateau.getCurrent().getEnergy() >= carte.getEnergyCost()) {
                    plateau.getCurrent().removeEnergy(carte.getEnergyCost());
                    energyPlayer1.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                    if (carte instanceof Creature) {
                        switch (plateau.getCurrent().getListeCreature().size()) {
                            case 0:
                                Card1P1.setImage(new Image(carte.getUrlPicture()));
                                Card1P1.setOpacity(1);
                                break;
                            case 1:
                                Card2P1.setImage(new Image(carte.getUrlPicture()));
                                Card2P1.setOpacity(1);
                                break;
                            case 2:
                                Card3P1.setImage(new Image(carte.getUrlPicture()));
                                Card3P1.setOpacity(1);
                                break;
                            case 3:
                                Card4P1.setImage(new Image(carte.getUrlPicture()));
                                Card4P1.setOpacity(1);
                                break;
                            default:
                                break;
                        }
                        currentCreature = (Creature) carte;
                        plateau.getCurrent().getListeCreature().add(currentCreature);
                        buttonBattle1.setDisable(false);
                    } else if (carte instanceof Ritual) {
                        Ritual ritual = (Ritual) carte;
                        CimetiereP1.setImage(new Image(carte.getUrlPicture()));
                        plateau.RitualDamage(ritual);
                        hpPlayer2.setText(Integer.toString(plateau.getOpponent().getLifePoints()));
                        hpPlayer1.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
                    }
                    else
                    {
                        CimetiereP1.setImage(new Image(carte.getUrlPicture()));
                    }
                    rectP1.setWidth(0);
                    rectP1.setHeight(0);
                    posX = rectP1.getX();

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
        Card carte = drawPlayer();
        for(int i=0;i<plateau.refreshEnergy();i++)
        {
            if(plateau.getCurrent().getEnergy()<plateau.refreshEnergy())
            {
                plateau.getCurrent().addEnergy();
            }
        }
        plateau.getCurrent().addEnergy();
        energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
        rectP2.setFill(new ImagePattern(new Image(carte.getUrlPicture())));
        panePlayer2.getChildren().add(rectP2);
        rectP2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            //Lorsqu'on clique sur la 1ère carte de la main du joueur 1, l'ajoute au plateau
            public void handle(MouseEvent me) {
                if (plateau.getCurrent().getEnergy() >= carte.getEnergyCost()) {
                    plateau.getCurrent().removeEnergy(carte.getEnergyCost());
                    energyPlayer2.setText(Integer.toString(plateau.getCurrent().getEnergy()));
                    if (carte instanceof Creature) {
                        switch (plateau.getCurrent().getListeCreature().size()) {
                            case 0:
                                Card1P2.setImage(new Image(carte.getUrlPicture()));
                                Card1P2.setOpacity(1);
                                break;
                            case 1:
                                Card2P2.setImage(new Image(carte.getUrlPicture()));
                                Card2P2.setOpacity(1);
                                break;
                            case 2:
                                Card3P2.setImage(new Image(carte.getUrlPicture()));
                                Card3P2.setOpacity(1);
                                break;
                            case 3:
                                Card4P2.setImage(new Image(carte.getUrlPicture()));
                                Card4P2.setOpacity(1);
                                break;
                            default:
                                break;
                        }
                        currentCreature = (Creature) carte;
                        plateau.getCurrent().getListeCreature().add(currentCreature);
                        buttonBattle2.setDisable(false);
                    }
                    else if (carte instanceof Ritual) {
                        Ritual ritual = (Ritual) carte;
                        CimetiereP2.setImage(new Image(carte.getUrlPicture()));
                        plateau.RitualDamage(ritual);
                        hpPlayer2.setText(Integer.toString(plateau.getCurrent().getLifePoints()));
                        hpPlayer1.setText(Integer.toString(plateau.getOpponent().getLifePoints()));
                    }
                    else {
                        CimetiereP2.setImage(new Image(carte.getUrlPicture()));
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
        // Make button player 1 disable
        buttonFinish1.setDisable(true);
        buttonBattle1.setDisable(true);
        buttonPlayer1.setDisable(true);
        // Make button player 1 not visable
        buttonFinish1.setVisible(false);
        buttonBattle1.setVisible(false);


        // Make button player 2 not Disable
        if(plateau.getOpponent().getListeCreature().size() > 0)buttonBattle2.setDisable(false);
        buttonFinish2.setDisable(false);
        buttonPlayer2.setDisable(false);
        // Make button player 2 visable
        buttonFinish2.setVisible(true);
        buttonBattle2.setVisible(true);

        plateau.FinTour();
    }

    @FXML
    public void finishTurn2() {
        // Make button player 2 disable
        buttonFinish2.setDisable(true);
        buttonBattle2.setDisable(true);
        buttonPlayer2.setDisable(true);
        // Make button player 2 not visable
        buttonFinish2.setVisible(false);
        buttonBattle2.setVisible(false);

        // Make button player 1 not Disable
        if(plateau.getOpponent().getListeCreature().size() > 0)buttonBattle1.setDisable(false);
        buttonFinish1.setDisable(false);
        buttonPlayer1.setDisable(false);
        // Make button player 1 visable
        buttonFinish1.setVisible(true);
        buttonBattle1.setVisible(true);

        plateau.FinTour();
    }

    @FXML
    public void Battle1() {
        int nbCardOpponent = plateau.getOpponent().getListeCreature().size();
        plateau.bataille();

        hpPlayer2.setText(Integer.toString(plateau.getOpponent().getLifePoints()));
        buttonBattle1.setDisable(true);
        updateFieldCard1(nbCardOpponent);
    }

    @FXML
    public void Battle2() {
        int nbCardOpponent = plateau.getOpponent().getListeCreature().size();
        plateau.bataille();
        hpPlayer1.setText(Integer.toString(plateau.getOpponent().getLifePoints()));
        buttonBattle2.setDisable(true);
        updateFieldCard2(nbCardOpponent);
    }

    @FXML
    public void updateFieldCard1(int nbCardOpponent) {
        if(nbCardOpponent >= 1) {
            Card1P2.setImage(new Image("/carte.jpg"));
            Card1P2.setOpacity(0.3);
        }
        if(nbCardOpponent >= 2) {
            Card2P2.setImage(new Image("/carte.jpg"));
            Card2P2.setOpacity(0.3);
        }
        if(nbCardOpponent >= 3) {
            Card3P2.setImage(new Image("/carte.jpg"));
            Card3P2.setOpacity(0.3);
        }
        if(nbCardOpponent >= 4) {
            Card4P2.setImage(new Image("/carte.jpg"));
            Card4P2.setOpacity(0.3);
        }

        if(plateau.getOpponent().getListeCreature().size() >= 1) {
            Card1P2.setImage(new Image(plateau.getOpponent().getListeCreature().get(0).getUrlPicture()));
            Card1P2.setOpacity(1);
        }
        if(plateau.getOpponent().getListeCreature().size() >= 2) {
            Card1P2.setImage(new Image(plateau.getOpponent().getListeCreature().get(1).getUrlPicture()));
            Card1P2.setOpacity(1);
        }
        if(plateau.getOpponent().getListeCreature().size() >= 3) {
            Card1P2.setImage(new Image(plateau.getOpponent().getListeCreature().get(2).getUrlPicture()));
            Card1P2.setOpacity(1);
        }
        if(plateau.getOpponent().getListeCreature().size() >= 4) {
            Card1P2.setImage(new Image(plateau.getOpponent().getListeCreature().get(3).getUrlPicture()));
            Card1P2.setOpacity(1);
        }

        if (plateau.getOpponent().getFausse().getCardPool().size() > 0){
            CimetiereP2.setImage(new Image(plateau.getOpponent().getFausse().getCardPool().get(
                    plateau.getOpponent().getFausse().getCardPool().size()-1).getUrlPicture()));
        }
    }

    @FXML
    public void updateFieldCard2(int nbCardOpponent) {
        if(nbCardOpponent >= 1) {
            Card1P1.setImage(new Image("/carte.jpg"));
            Card1P1.setOpacity(0.3);
        }
        if(nbCardOpponent >= 2) {
            Card2P1.setImage(new Image("/carte.jpg"));
            Card2P1.setOpacity(0.3);
        }
        if(nbCardOpponent >= 3) {
            Card3P1.setImage(new Image("/carte.jpg"));
            Card3P1.setOpacity(0.3);
        }
        if(nbCardOpponent >= 4) {
            Card4P1.setImage(new Image("/carte.jpg"));
            Card4P1.setOpacity(0.3);
        }

        if(plateau.getOpponent().getListeCreature().size() >= 1) {
            Card1P1.setImage(new Image(plateau.getOpponent().getListeCreature().get(0).getUrlPicture()));
            Card1P1.setOpacity(1);
        }
        if(plateau.getOpponent().getListeCreature().size() >= 2) {
            Card1P1.setImage(new Image(plateau.getOpponent().getListeCreature().get(1).getUrlPicture()));
            Card1P1.setOpacity(1);
        }
        if(plateau.getOpponent().getListeCreature().size() >= 3) {
            Card1P1.setImage(new Image(plateau.getOpponent().getListeCreature().get(2).getUrlPicture()));
            Card1P1.setOpacity(1);
        }
        if(plateau.getOpponent().getListeCreature().size() >= 4) {
            Card1P1.setImage(new Image(plateau.getOpponent().getListeCreature().get(3).getUrlPicture()));
            Card1P1.setOpacity(1);
        }

        if (plateau.getOpponent().getFausse().getCardPool().size() > 0){
            CimetiereP1.setImage(new Image(plateau.getOpponent().getFausse().getCardPool().get(
                    plateau.getOpponent().getFausse().getCardPool().size()-1).getUrlPicture()));
        }
    }
}