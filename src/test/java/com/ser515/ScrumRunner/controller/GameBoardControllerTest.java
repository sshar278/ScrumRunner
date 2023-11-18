package com.ser515.ScrumRunner.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardControllerTest extends ApplicationTest {

    private GameBoardController controller;

    @Override
    public void start(Stage stage) throws Exception {
        // Initialize your scene and controller
        VBox root = new VBox();
        controller = new GameBoardController();
        // You need to manually inject JavaFX components here, or load them via FXML
        controller.rollButton = new Button("Roll");
        controller.diceImage = new ImageView();
        controller.userPiece = new Circle(10);
        controller.gridPane = new GridPane();

        root.getChildren().addAll(controller.rollButton, controller.diceImage, controller.userPiece, controller.gridPane);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testRollAction() throws InterruptedException {
        // Simulate button click
        clickOn(controller.rollButton);
        Thread.sleep(1000); // Adjust this duration as needed

        // Wait for the button to be disabled (considering asynchronous behavior)
        WaitForAsyncUtils.waitForFxEvents();

        // Now verify
        assertFalse(controller.rollButton.isDisabled());
    }
    @Test
    public void testHandlePaneClick() {
        // Use Platform.runLater to interact with JavaFX components
        Platform.runLater(() -> {
            Pane testPane = new Pane();
            testPane.setId("testPane");
            controller.gridPane.getChildren().add(testPane);

            // Simulate pane click
            clickOn(testPane);

            // Assertions or verifications related to the click event
        });

        WaitForAsyncUtils.waitForFxEvents();
    }
}