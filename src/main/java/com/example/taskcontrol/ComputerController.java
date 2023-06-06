package com.example.taskcontrol;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class ComputerController {
    public TextField errorText;
    public ChoiceBox<TypeError> typeError;
    int computerID;
    public void init(int computerID)
    {
        this.computerID=computerID;
        typeError.getItems().addAll(TypeError.values());
        typeError.getSelectionModel().select(0);
    }
    @FXML
    private void addError()
    {
        if(!Objects.equals(errorText.getText(), "")) {
            DatabaseAdapter.getDBConnection();
            DatabaseAdapter.addErrorTask(new ErrorTask(errorText.getText(), LocalDateTime.now(), false, computerID,typeError.getSelectionModel().getSelectedItem(), -1));
            new Alert(Alert.AlertType.INFORMATION,"Ошибка отправлена администратору!", ButtonType.CLOSE).show();
        }
    }

}
