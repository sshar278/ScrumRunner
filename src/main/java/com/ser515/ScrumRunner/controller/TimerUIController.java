package com.ser515.ScrumRunner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class TimerUIController {

    @FXML
    private Label timerLabel;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    @FXML
    private void handlePlay() {
        // Implement what should happen when the PLAY button is clicked
        System.out.println("Play button clicked");
        // Start or resume the timer here
    }

    @FXML
    private void handleReset() {
        // Implement what should happen when the RESET button is clicked
        System.out.println("Reset button clicked");
        // Reset the timer here
    }

    // Initialization method if needed
    @FXML
    public void initialize() {
        // Initialize your controller here if necessary
    }
}

