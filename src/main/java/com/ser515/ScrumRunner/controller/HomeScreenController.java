package com.ser515.ScrumRunner.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable{
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // You can perform initialization here if needed
    }

    public void handleStartButton(ActionEvent actionEvent) throws IOException {
        // Load the next screen when Start button is clicked
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserStory.fxml"));
        Parent root = loader.load();

        // Access the controller of the next screen (assuming the controller has the method setStage)
        UserStoryController nextScreenController = loader.getController();
        nextScreenController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void handleExitButton(ActionEvent actionEvent) {
        // Close the application when Exit button is clicked
        stage.close();
    }
    
}
