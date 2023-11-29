package com.ser515.ScrumRunner.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class InputFormControllerTest extends ApplicationTest {

    private InputFormController controller;

    @Override
    public void start(Stage stage) throws Exception {
        controller = new InputFormController();
        controller.nameTextField = new TextField();
        controller.sprintsTextField = new TextField();
        controller.durationTextField = new TextField();
        controller.capacityTextField = new TextField();
        controller.rolesChoiceBox = new ChoiceBox<>();
        controller.submitButton = new Button();

        controller.initialize();

    }

    @Test
    public void testInitialize() {
        assertEquals(5, controller.rolesChoiceBox.getItems().size());
        assertEquals("Developer", controller.rolesChoiceBox.getValue());
    }

    @Test
    public void testHandleSubmitButtonAction() {
        assertNotNull(controller.nameTextField);
        assertNotNull(controller.sprintsTextField);
    }

}