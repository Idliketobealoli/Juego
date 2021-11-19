package com.example.juego;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameController {
    private StackPane track;
    private Rectangle topWall;
    private Rectangle bottomWall;
    private Rectangle leftWall;
    private Rectangle rightWall;
    private Rectangle pj;

    private final double SPEED;

    private Timeline up;
    private Timeline down;
    private Timeline right;
    private Timeline left;

    public GameController(StackPane track, Rectangle topWall, Rectangle bottomWall,
                          Rectangle leftWall, Rectangle rightWall, Rectangle pj) {
        this.track = track;
        this.topWall = topWall;
        this.bottomWall = bottomWall;
        this.leftWall = leftWall;
        this.rightWall = rightWall;
        this.pj = pj;

        this.SPEED = 2;

        initialize();
        startControls();
    }

    private void initialize() {
        this.up = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveUp();
        }));
        up.setCycleCount(Animation.INDEFINITE);

        this.down = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveDown();
        }));
        down.setCycleCount(Animation.INDEFINITE);

        this.left = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveLeft();
        }));
        left.setCycleCount(Animation.INDEFINITE);

        this.right = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            moveRight();
        }));
        right.setCycleCount(Animation.INDEFINITE);
    }

    private void moveRight() {
        pj.setTranslateX(pj.getTranslateX() + SPEED);
    }

    private void moveLeft() {
        pj.setTranslateX(pj.getTranslateX() - SPEED);
    }

    private void moveDown() {
        pj.setTranslateY(pj.getTranslateY() + SPEED);
    }

    private void moveUp() {
        pj.setTranslateY(pj.getTranslateY() - SPEED);
    }

    private void startControls() {
        track.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ESCAPE) {
                    System.exit(0);
                }
                if((keyEvent.getCode() == KeyCode.UP) || (keyEvent.getCode() == KeyCode.W)){
                    down.stop();
                    left.stop();
                    right.stop();
                    up.play();
                }
                if((keyEvent.getCode() == KeyCode.DOWN) || (keyEvent.getCode() == KeyCode.S)){
                    up.stop();
                    left.stop();
                    right.stop();
                    down.play();
                }
                if((keyEvent.getCode() == KeyCode.LEFT) || (keyEvent.getCode() == KeyCode.A)){
                    up.stop();
                    down.stop();
                    right.stop();
                    left.play();
                }
                if((keyEvent.getCode() == KeyCode.RIGHT) || (keyEvent.getCode() == KeyCode.D)){
                    up.stop();
                    down.stop();
                    left.stop();
                    right.play();
                }
            }
        });

        track.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if((keyEvent.getCode() == KeyCode.UP) || (keyEvent.getCode() == KeyCode.W) ||
                        (keyEvent.getCode() == KeyCode.DOWN) || (keyEvent.getCode() == KeyCode.S) ||
                        (keyEvent.getCode() == KeyCode.LEFT) || (keyEvent.getCode() == KeyCode.A) ||
                        (keyEvent.getCode() == KeyCode.RIGHT) || (keyEvent.getCode() == KeyCode.D)){
                    up.stop();
                    down.stop();
                    left.stop();
                    right.stop();
                }
            }
        });

        track.setFocusTraversable(true);
    }


}
