package com.ser515.ScrumRunner.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.ser515.ScrumRunner.model.QuestionForm;
import com.ser515.ScrumRunner.model.Results;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.ToggleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

@Controller
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

    private ToggleGroup optionsToggleGroup;

    @Autowired
    private Results quizResults = new Results();

    private QuestionForm currentQuestionData;

    private Timeline timeline;
    private int timeSeconds = 25;

    // Reference to your timer label in FXML
    @FXML
    private Label timerLabel;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }



    @FXML
    private void initialize() throws IOException {

        optionsToggleGroup = new ToggleGroup();

        option1RadioButton.setToggleGroup(optionsToggleGroup);
        option2RadioButton.setToggleGroup(optionsToggleGroup);
        option3RadioButton.setToggleGroup(optionsToggleGroup);
        option4RadioButton.setToggleGroup(optionsToggleGroup);


        currentQuestionData = getRandomQuestion();
        List<String> options = currentQuestionData.getOptions();
        questionLabel.setText(currentQuestionData.getQuestionText());
        option1RadioButton.setText(options.get(0));
        option2RadioButton.setText(options.get(1));
        option3RadioButton.setText(options.get(2));
        option4RadioButton.setText(options.get(3));

        startTimer(stage);
    }

    public QuestionForm getRandomQuestion() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new ClassPathResource("assets/questions/questions.json").getFile();
        JsonNode rootNode = mapper.readTree(file);
        ArrayNode questionsNode = (ArrayNode) rootNode.path("questions");
        JsonNode selectedNode = questionsNode.get(new Random().nextInt(questionsNode.size()));

        return convertToQuestionForm(selectedNode);
    }

    private QuestionForm convertToQuestionForm(JsonNode questionNode) {
        QuestionForm questionForm = new QuestionForm();
        questionForm.setQuestionText(questionNode.get("question").asText());

        List<String> options = new ArrayList<>();
        questionNode.get("answers").forEach(jsonNode ->
                options.add(jsonNode.get("option").asText()));
        questionForm.setOptions(options);
        questionNode.get("answers").forEach(jsonNode ->{
            if(jsonNode.get("correct").asBoolean()){
                questionForm.setCorrectAnswer(jsonNode.get("option").asText());
            }
        } );
        return questionForm;
    }
    @FXML
    private void handleSubmit() {
        try {
            String selectedOption = "";
            if (option1RadioButton != null && option1RadioButton.isSelected()) {
                selectedOption = option1RadioButton.getText();
            } else if (option2RadioButton != null && option2RadioButton.isSelected()) {
                selectedOption = option2RadioButton.getText();
            } else if (option3RadioButton != null && option3RadioButton.isSelected()) {
                selectedOption = option3RadioButton.getText();
            } else if (option4RadioButton != null && option4RadioButton.isSelected()) {
                selectedOption = option4RadioButton.getText();
            }
            if (currentQuestionData != null) {
                currentQuestionData.setSelectedAnswer(selectedOption);
                if (selectedOption.equals(currentQuestionData.getCorrectAnswer())) {
                    quizResults.addCorrectAnswer(currentQuestionData.getId());
                    System.out.println("Correct answer");
                } else {
                    System.out.println("Wrong answer");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


}



    public void startTimer(Stage stage) {
        if (timeline != null) {
            timeline.stop();
        }

        // Update timerLabel every second
        timerLabel.setText(timeToString(timeSeconds));

        // Set up the Timeline to count down every second
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeSeconds--;
                timerLabel.setText(timeToString(timeSeconds));
                if (timeSeconds <= 0) {
                    timeline.stop();
                    stage.close();
                }
            }
        }));
        timeline.playFromStart();
    }

    private String timeToString(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
