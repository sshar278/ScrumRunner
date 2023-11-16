package com.ser515.ScrumRunner.controller;
import com.ser515.ScrumRunner.model.SprintInput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class InputFormController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField sprintsTextField;
    @FXML
    private TextField durationTextField;
    @FXML
    private TextField capacityTextField;
    @FXML
    private ChoiceBox<String> rolesChoiceBox;
    @FXML
    private Button submitButton;

    @FXML
    public void initialize() {
        rolesChoiceBox.getItems().addAll("Developer", "Tester", "Product Owner", "Scrum Master", "Auto Assign me a role");
        rolesChoiceBox.getSelectionModel().selectFirst(); // select the first item by default
    }

    @FXML
    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        SprintInput details = new SprintInput();
        details.setName(nameTextField.getText());
        details.setNoOfSprints(Integer.parseInt(sprintsTextField.getText()));
        details.setSprintDuration(Integer.parseInt(durationTextField.getText()));
        details.setTeamCapacity(Integer.parseInt(capacityTextField.getText()));
        details.setRoleAssignment(rolesChoiceBox.getValue());
        System.out.println(details.toString());
        // Store details object somewhere, e.g., in a database or in-memory store...
        //your part -- @sshar278
        // Navigate to the next screen
        loadNextFXML();
    }

    private void loadNextFXML() throws IOException{

            // Load the new FXML
            Parent nextRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameBoard/GameBoard.fxml")));
            Scene scene = new Scene(nextRoot);
            Stage stage = (Stage) submitButton.getScene().getWindow(); // get the current stage
            // Set the minimum window size
            stage.setMinWidth(800);
            stage.setMinHeight(600);

            stage.setScene(scene);
            stage.show();
    }
}