package com.ser515.ScrumRunner.model;

import java.util.List;

public class QuestionForm {

    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private String selectedAnswer;

    private Long id;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getSelectedAnswer(){return selectedAnswer;}

    public void setSelectedAnswer(String selectedAnswer){this.selectedAnswer =  selectedAnswer;}

    @Override
    public String toString() {
        return "QuestionForm{" +
                "questionText='" + questionText + '\'' +
                ", options=" + options +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", selectedAnswer='" + selectedAnswer + '\'' +
                ", id=" + id +
                '}';
    }
}
