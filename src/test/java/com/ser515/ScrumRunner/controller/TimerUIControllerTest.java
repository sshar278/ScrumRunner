package com.ser515.ScrumRunner.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class TimerUIControllerTest extends ApplicationTest {

    private TimerUIController controller;

    @Override
    public void start(Stage stage) {
        controller = new TimerUIController();
        controller.timerLabel = new Label();
        controller.playButton = new Button();
        controller.resetButton = new Button();

        controller.initialize();

        VBox root = new VBox(controller.timerLabel, controller.playButton, controller.resetButton);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void testInitialize() {
        Platform.runLater(() -> {

            verifyThat(controller.timerLabel, hasText(""));
            verifyThat(controller.playButton, hasText(""));
        });

        WaitForAsyncUtils.waitForFxEvents();
    }

    @Test
    public void testHandlePlay() {
        clickOn(controller.playButton);
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotEquals("00:00:00", controller.timerLabel.getText());

        clickOn(controller.playButton);
        String currentTime = controller.timerLabel.getText();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(currentTime, controller.timerLabel.getText());
    }

    @Test
    public void testHandleReset() {

        clickOn(controller.playButton);

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickOn(controller.resetButton);
        verifyThat(controller.timerLabel, hasText(""));
    }
}

