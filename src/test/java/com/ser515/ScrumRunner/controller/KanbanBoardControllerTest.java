package com.ser515.ScrumRunner.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;


import static org.testfx.api.FxAssert.verifyThat;

public class KanbanBoardControllerTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        try {
            KanbanBoardController c = new KanbanBoardController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/KanbanBoard.fxml"));
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
    public void testToDOInputTextField() {
        clickOn("#toDoListView");
        verifyThat("#toDoInput", NodeMatchers.isNotNull());
    }
    @Test
    public void testStartGameButton() {
        clickOn("#toDoListView");
        verifyThat("#inProgressInput", NodeMatchers.isNotNull());
    }
}