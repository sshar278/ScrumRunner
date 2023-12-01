package com.ser515.ScrumRunner.controller;

import javafx.event.ActionEvent;
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


    public Button btnSimulator;
    @FXML
    Button startGameButton;
    @FXML
    private Button btnDiceRoll;
    @FXML
    Button btnEnd;

    @FXML
    private Stage primaryStage; // Field to store the primary stage

    // Setter for the primary stage
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void startGame() {
        System.out.println("Clicked Start Button!");
        try {
            // Close the primary stage here before showing the new one
            primaryStage.close();
            
            // Load the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InputForm/InputForm.fxml"));
            Parent root1 = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void btnDiceRoll() throws IOException {
        System.out.println("Dice Roll Button Clicked!");
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/tabs/LoggerTab.fxml"));
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
    private void NextButton1() {
        System.out.println("Next Button 1 Clicked");
        try {
            // Close the primary stage here before showing the new one
            primaryStage.close();

            // Load the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Tutorial/Tutorial2.fxml"));
            Parent root1 = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void NextButton2() {
        System.out.println("Next Button 2 Clicked");
        try {
            // Close the primary stage here before showing the new one
            primaryStage.close();

            // Load the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Tutorial/Tutorial3.fxml"));
            Parent root1 = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void NextButton3() {
        System.out.println("Next Button 3 Clicked");
        try {
            // Close the primary stage here before showing the new one
            primaryStage.close();

            // Load the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Start/Start.fxml"));
            Parent root1 = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitGame(ActionEvent event) {
        System.out.println("Exiting game....");
        Stage stage = (Stage) btnEnd.getScene().getWindow();
        stage.close();

    }

    // startSimulator function to be completed
    @FXML
    private void startSimulator(ActionEvent event) throws IOException{
        try{
            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBoard/SimulatorBoard.fxml")));
            Scene scene = new Scene(nextRoot);
            Stage stage = (Stage) btnSimulator.getScene().getWindow(); // get the current stage
            // Set the minimum window size
            stage.setMinWidth(800);
            stage.setMinHeight(600);

            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}