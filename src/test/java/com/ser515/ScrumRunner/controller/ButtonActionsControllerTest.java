package com.ser515.ScrumRunner.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.api.FxAssert.verifyThat;

public class ButtonActionsControllerTest extends ApplicationTest {

    //private ButtonActionsController controller;

    @Override
    public void start(Stage primaryStage) {
        try {
            ButtonActionsController c = new ButtonActionsController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Start/Start.fxml"));
            //loader.setController(c);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            c.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testExitGameButton() {
        clickOn("#gridPane");
        verifyThat("#btnEnd", NodeMatchers.isNotNull());
    }
    @Test
    public void testStartGameButton() {
        clickOn("#gridPane");
        verifyThat("#btnStart", NodeMatchers.isNotNull());
    }

}