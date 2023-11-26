package com.ser515.ScrumRunner.controller;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.Objects;
import java.util.Random;


@Component
public class GameBoardController {

    public ImageView imageView1;
    public ImageView diceImage;
    public Button rollButton;
    public Circle userPiece;
    public GridPane gridPane;

    @FXML
    private Button btnSpring;
    @FXML
    private Label lblSpring;

    private final double[][] midpoints = {
        // List of coordinates where the user piece is supposed to be moved to
           {58.0, 440.0},   //Start
           {218.0, 440.0},
           {378.0, 440.0},
           {528.0, 440.0},
           {688.0, 440.0},  //Corner Tile
           {688.0, 330.0},
           {688.0, 220.0},
           {688.0, 110.0},
           {688.0, 8.0},   //Corner Tile
           {528.0, 8.0},
           {378.0, 8.0},
           {218.0, 8.0},
           {58.0, 8.0},    //Corner Tile
           {58.0, 110.0},
           {58.0, 220.0},
           {58.0, 330.0},
           //{58.0, 440.0}

    };

    private int currentPosition = 0;

    @FXML
    public void roll(ActionEvent actionEvent) {
        System.out.println("Button Clicked");
        rollButton.setDisable(true);

        Thread thread = new Thread(() -> {
            System.out.println("Thread Running");
            Random random = new Random();
            int diceValue = random.nextInt(6) + 1;
            try {
                for (int i = 0; i < 15; i++) {
//                    diceImage = new ImageView();
                    diceValue = random.nextInt(6) + 1;
                    File file = new File("@../../assets/dice-" + diceValue + ".png");
                    diceImage.setImage(new Image(String.valueOf(file)));
//                    System.out.println(file);
                    Thread.sleep(50);
                }
                currentPosition = 0;
                moveUserPiece(diceValue);
                rollButton.setDisable(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

    }

    @FXML
    private void handlePaneClick(MouseEvent event) {
        Pane clickedPane = (Pane) event.getSource();
        System.out.println("Clicked Pane ID: " + clickedPane.getId());
    }

    private void moveUserPiece(int steps) {
        if (steps < 1) {
            System.out.println("Invalid number of steps.");
            return;
        }

        // int totalSteps = midpoints.length;
        int destinationIndex = (currentPosition + steps)%16;
        System.out.println("destinationIndex: "+destinationIndex);
        if (destinationIndex >= midpoints.length) {
            // destinationIndex = destinationIndex - midpoints.length;
        }

        double[] destination = midpoints[destinationIndex];
        System.out.println("coordinates: "+destination[0] +" "+ destination[1]);

        Platform.runLater(() -> {
            gridPane.getChildren().remove(userPiece);
            gridPane.getChildren().add(userPiece);
        });

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1.5), userPiece);
        transition.setToX(destination[0]);
        transition.setToY(destination[1]);
        transition.play();

        currentPosition = destinationIndex;
}
}