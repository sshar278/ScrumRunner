package com.ser515.ScrumRunner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Tab;
import javafx.scene.shape.Circle;
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

    @FXML
    private Button btnSpring;
    @FXML
    private Label lblSpring;

    private final double[][] midpoints = {
            {0.0, 384.0},  // Midpoint of Box at Row 4, Column 0
            {96.0, 384.0}, // Midpoint of Box at Row 4, Column 1
            {192.0, 384.0}, // Midpoint of Box at Row 4, Column 2
            {288.0, 384.0}, // Midpoint of Box at Row 4, Column 3
            {384.0, 384.0}, // Midpoint of Box at Row 4, Column 4
            {384.0, 288.0}, // Midpoint of Box at Row 3, Column 4
            {384.0, 192.0}, // Midpoint of Box at Row 2, Column 4
            {384.0, 96.0}, // Midpoint of Box at Row 1, Column 4
            {384.0, 0.0}, // Midpoint of Box at Row 0, Column 4
            {288.0, 0.0}, // Midpoint of Box at Row 0, Column 3
            {192.0, 0.0}, // Midpoint of Box at Row 0, Column 2
            {96.0, 0.0}, // Midpoint of Box at Row 0, Column 1
            {0.0, 0.0},  // Midpoint of Box at Row 0, Column 0
            {0.0, 96.0},  // Midpoint of Box at Row 1, Column 0
            {0.0, 192.0},  // Midpoint of Box at Row 2, Column 0
            {0.0, 288.0},  // Midpoint of Box at Row 3, Column 0
            {0.0, 384.0},  // Midpoint of Box at Row 4, Column 0
    };

    @FXML
    public void roll(ActionEvent actionEvent) {
//        System.out.println("Button Clicked");
        rollButton.setDisable(true);

        Thread thread = new Thread(() -> {
            System.out.println("Thread Running");
            try {
                for (int i = 0; i < 15; i++) {
//                    diceImage = new ImageView();
                    Random random = new Random();
//                    System.out.println(random.nextInt(6)+1);
                    File file = new File("@../../assets/dice-" + (random.nextInt(6) + 1) + ".png");
                    diceImage.setImage(new Image(String.valueOf(file)));
//                    System.out.println(file);
                    Thread.sleep(50);
                }
                rollButton.setDisable(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

    }
}
