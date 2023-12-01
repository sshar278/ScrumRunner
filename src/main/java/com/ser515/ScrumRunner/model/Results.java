package com.ser515.ScrumRunner.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Results {
    private int totalCorrect;
    private List<Long> correctQuestionIds;

    public Results() {
        this.totalCorrect = 0;
        this.correctQuestionIds = new ArrayList<>();
    }

    public void addCorrectAnswer(Long questionId) {
        totalCorrect++;
        correctQuestionIds.add(questionId);
    }

    // Getters
    public int getTotalCorrect() {
        return totalCorrect;
    }

    public List<Long> getCorrectQuestionIds() {
        return correctQuestionIds;
    }
}
