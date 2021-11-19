package com.example.juego;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Game extends BorderPane {
    private final StackPane track;
    private Rectangle topWall;
    private Rectangle bottomWall;
    private Rectangle leftWall;
    private Rectangle rightWall;
    private Rectangle pj;
    private GameController controller;

    public Game() {
        this.track = new StackPane();
        track.setMinSize(0, 0);
        this.topWall = new Rectangle();
        this.bottomWall = new Rectangle();
        this.leftWall = new Rectangle();
        this.rightWall = new Rectangle();
        this.pj = new Rectangle();
        this.controller = new GameController(track, topWall, bottomWall, leftWall, rightWall, pj);

        topWall.heightProperty().bind(track.heightProperty().divide(40));
        topWall.widthProperty().bind(track.widthProperty());
        topWall.setFill(new ImagePattern(new Image("wall.png")));
        bottomWall.heightProperty().bind(track.heightProperty().divide(40));
        bottomWall.widthProperty().bind(track.widthProperty());
        bottomWall.setFill(new ImagePattern(new Image("wall.png")));
        leftWall.heightProperty().bind(track.heightProperty());
        leftWall.widthProperty().bind(track.widthProperty().divide(40));
        leftWall.setFill(new ImagePattern(new Image("wall.png")));
        rightWall.heightProperty().bind(track.heightProperty());
        rightWall.widthProperty().bind(track.widthProperty().divide(40));
        rightWall.setFill(new ImagePattern(new Image("wall.png")));

        pj.heightProperty().bind(track.heightProperty().divide(12));
        pj.widthProperty().bind(pj.heightProperty().divide(2));
        // Image pjImage = new Image("pj.png");
        pj.setFill(Color.BLUEVIOLET);

        track.getChildren().addAll(topWall, bottomWall, leftWall, rightWall, pj);
        StackPane.setAlignment(topWall, Pos.TOP_CENTER);
        StackPane.setAlignment(bottomWall, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(leftWall, Pos.CENTER_LEFT);
        StackPane.setAlignment(rightWall, Pos.CENTER_RIGHT);
        StackPane.setAlignment(pj, Pos.CENTER);

        this.setCenter(track);
    }
}
