package com.ser515.ScrumRunner.controller;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KanbanBoardController {
    @FXML
    private ListView<String> toDoListView;

    @FXML
    private ListView<String> inProgressListView;

    @FXML
    private ListView<String> doneListView;

    @FXML
    private TextField toDoInput;

    @FXML
    private TextField inProgressInput;

    @FXML
    private TextField doneInput;

    public void addToDo() {
      String task = toDoInput.getText();
      if(!task.isEmpty()){
          toDoListView.getItems().add(task);
          toDoInput.clear();
      }

    }

    public void addInProgress() {
        String task = inProgressInput.getText();
        if (!task.isEmpty()) {
            inProgressListView.getItems().add(task);
            inProgressInput.clear();
        }
    }

    public void addDone() {
        String task = doneInput.getText();
        if (!task.isEmpty()) {
            doneListView.getItems().add(task);
            doneInput.clear();
        }
    }
}
