package com.ser515.ScrumRunner.controller;

import com.ser515.ScrumRunner.model.QuestionForm;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import java.util.Arrays;

public class ModalFromController {

    @FXML
    private RadioButton option1RadioButton;
    @FXML
    private RadioButton option2RadioButton;
    @FXML
    private RadioButton option3RadioButton;
    @FXML
    private RadioButton option4RadioButton;

    private QuestionForm currentQuestion;

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
}
