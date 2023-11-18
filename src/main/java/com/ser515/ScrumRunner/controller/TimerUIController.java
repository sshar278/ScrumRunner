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
    public Label timerLabel;

    @FXML
    public Button playButton;

    @FXML
    public Button resetButton;

    public Timer timer;
    public TimerTask timerTask;
    public int secondsPassed = 0;
    public boolean running = false;

    @FXML
    public void handlePlay() {
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
    public void handleReset() {
        running = false;
        playButton.setText("Start");
        resetTimer();
    }

    @FXML
    public void initialize() {
        setupTimer();
    }

    public void setupTimer() {
        timer = new Timer();
    }

    public void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                Platform.runLater(() -> timerLabel.setText(formatTime(secondsPassed)));
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    public void pauseTimer() {
        timerTask.cancel();
    }

    public void resetTimer() {
        if (timerTask != null) {
            timerTask.cancel();
        }
        secondsPassed = 0;
        timerLabel.setText(formatTime(secondsPassed));
    }

    public String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
