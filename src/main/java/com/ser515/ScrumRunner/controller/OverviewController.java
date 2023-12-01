package com.ser515.ScrumRunner.controller;

import com.ser515.ScrumRunner.model.Results;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class OverviewController {

    @Autowired
    private Results quizResults;

    @FXML
    private void initialize() throws IOException {
        System.out.println(quizResults);
    }

}
