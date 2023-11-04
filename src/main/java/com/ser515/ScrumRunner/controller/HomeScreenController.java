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
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.Node;

public class HomeScreenController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent parent;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // You can perform initialization here if needed
    }

    public void handleStartButton(ActionEvent actionEvent) throws IOException {
        // Load the next screen when Start button is clicked
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserStory.fxml"));
        parent= loader.load();
        UserStoryController userStoryController= loader.getController();


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene= new Scene(parent);
        stage.setScene(scene);
        userStoryController.setStage(stage);
        stage.show();
    }

    public void handleExitButton(ActionEvent actionEvent) {
        // Close the application when Exit button is clicked

    }
    
}
