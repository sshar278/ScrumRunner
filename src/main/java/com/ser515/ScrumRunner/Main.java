package com.ser515.ScrumRunner;

import com.ser515.ScrumRunner.controller.ButtonActionsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext configurableApplicationContext;
    private Parent parent;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        configurableApplicationContext = SpringApplication.run(Main.class);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
        
        try {
            fxmlLoader.setLocation(getClass().getResource("/fxml/Main.fxml"));
            parent = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(parent, 800, 600));
        primaryStage.setTitle("ScrumRunner");
        
        // Retrieve the controller from the Spring context and set the primary stage
        ButtonActionsController controller = configurableApplicationContext.getBean(ButtonActionsController.class);
        controller.setPrimaryStage(primaryStage);

        primaryStage.show();
    }

    @Override
    public void stop() {
        configurableApplicationContext.close();
    }
}
