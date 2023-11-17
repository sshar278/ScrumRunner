// Refactored TimerUI Controller class, action to be integrated with the tiles
package com.ser515.ScrumRunner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUIController {

    @FXML
    private Label timerLabel;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    private Timer timer;
    private TimerTask timerTask;
    private int secondsPassed = 0;
    private boolean running = false;

    @FXML
    private void handlePlay() {
        if (!running) {
            running = true;
            playButton.setText("Pause");
            startTimer();
        } else {
            running = false;
            playButton.setText("Start");
            pauseTimer();
        }
    }

    @FXML
    private void handleReset() {
        running = false;
        playButton.setText("Start");
        resetTimer();
    }

    @FXML
    public void initialize() {
        setupTimer();
    }

    private void setupTimer() {
        timer = new Timer();
    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                Platform.runLater(() -> timerLabel.setText(formatTime(secondsPassed)));
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    private void pauseTimer() {
        timerTask.cancel();
    }

    private void resetTimer() {
        if (timerTask != null) {
            timerTask.cancel();
        }
        secondsPassed = 0;
        timerLabel.setText(formatTime(secondsPassed));
    }

    private String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
