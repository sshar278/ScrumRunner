package com.ser515.ScrumRunner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoggerTabController {

    @FXML
    private ImageView imageView2;

    // Initialize the animated GIF
//    public void initialize() {
////        String gifPath = "@../../assets/dice-roll.gif"; // Replace with the actual path or URL to your animated GIF
//        String gifPath = "https://media.tenor.com/YfLnhkuHzzAAAAAC/dice-roll.gif";
//        Image gifImage = new Image(Objects.requireNonNull(getClass().getResource(gifPath)).toExternalForm());
//        imageView2.setImage(gifImage);
//    }


    public Tab tabLogger;

    public ImageView imageView1;

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


}
