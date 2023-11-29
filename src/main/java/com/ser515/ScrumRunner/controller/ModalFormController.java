package com.ser515.ScrumRunner.controller;

import com.ser515.ScrumRunner.model.QuestionForm;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModalFormController {


    @FXML
    private RadioButton option1RadioButton;
    @FXML
    private RadioButton option2RadioButton;
    @FXML
    private RadioButton option3RadioButton;
    @FXML
    private RadioButton option4RadioButton;
    @FXML
    private Label questionLabel;

    private QuestionForm currentQuestion;

    @FXML
    private void initialize(){
            questionLabel.setText("How do you do?");
            option1RadioButton.setText("I opt 1");
            option2RadioButton.setText("I opt 2");
            option3RadioButton.setText("I opt 3");
            option4RadioButton.setText("I opt 4");
    }

    @FXML
    private void handleSubmit() {
        String selectedOption = "";
        if (option1RadioButton.isSelected()) {
            selectedOption = option1RadioButton.getText();
        } else if (option2RadioButton.isSelected()) {
            selectedOption = option2RadioButton.getText();
        } else if (option3RadioButton.isSelected()) {
            selectedOption = option3RadioButton.getText();
        } else if (option4RadioButton.isSelected()) {
            selectedOption = option4RadioButton.getText();
        }
        currentQuestion.setSelectedAnswer(selectedOption);

    }

    @FXML
    public void handlePlay() {
       System.out.println("This will start the timer");
    }

    @FXML
    public void handleReset() {
        System.out.println("This will reset the timer");
    }


}
