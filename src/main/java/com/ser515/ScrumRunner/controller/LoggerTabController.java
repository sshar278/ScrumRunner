package com.ser515.ScrumRunner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;
import java.util.Random;

@Component
public class LoggerTabController {


    public Tab tabLogger;

    public ImageView imageView1;
    public ImageView diceImage;
    public Button rollButton;

    @FXML
    private Button btnSpring;
    @FXML
    private Label lblSpring;

    private final int counter = 0;

    @FXML
    private void btnOnClickTest(ActionEvent onMouseClicked) {
        lblSpring.setText("It Works!");
        btnSpring.setDisable(true);
    }

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
                    File file = new File("@../../assets/dice-" + (random.nextInt(6)+1)+".png");
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
