package com.ser515.ScrumRunner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class LoggerTabController {
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
}
