package com.ser515.ScrumRunner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
@Component
public class LoggerTabController {
=======
import java.io.File;
import java.util.Objects;
import java.util.Random;

@Component
public class LoggerTabController {


    public Tab tabLogger;

    public ImageView imageView1;
    public ImageView diceImage;
    public Button rollButton;

>>>>>>> 2ed3b18669d997245f5d1ba295dd8ee5b73fa751
    @FXML
    private Button btnSpring;
    @FXML
    private Label lblSpring;

    private int counter = 0;

    @FXML
    private void btnOnClickTest(ActionEvent onMouseClicked) {
        lblSpring.setText("It Works!");
        btnSpring.setDisable(true);
    }
<<<<<<< HEAD
=======

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
>>>>>>> 2ed3b18669d997245f5d1ba295dd8ee5b73fa751
}
