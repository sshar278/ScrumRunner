package com.ser515.ScrumRunner.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Objects;

@Controller
public class ButtonActionsController {

    @FXML
    private Button startGameButton;

    @FXML
    private void startGame() throws IOException {
        // Load the new FXML
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/InputForm/InputForm.fxml")));

        // Create a new scene with the new root
        Scene scene = new Scene(newRoot);

        // Get the stage from the start button and set the new scene
        Stage stage = (Stage) startGameButton.getScene().getWindow();
        stage.setScene(scene);
    }

}