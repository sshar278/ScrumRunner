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
        System.out.println("Clicked Start Button!");
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InputForm/InputForm.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitGame() throws IOException {
        System.out.println("Exit game");
    }
}