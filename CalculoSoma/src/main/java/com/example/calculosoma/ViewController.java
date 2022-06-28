package com.example.calculosoma;

import com.example.calculosoma.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class ViewController {
    @FXML
    private Label labelResult;
    @FXML
    private TextField txtNumberOne;
    @FXML
    private TextField txtNumberTwo;
    @FXML
    private Button btSum;

    @FXML
    protected void onSumButonClick() {

        try {
            Locale.setDefault(Locale.US);
            double number1 = Double.parseDouble(txtNumberOne.getText());
            double number2 = Double.parseDouble(txtNumberTwo.getText());
            double sum = number1 + number2;

            labelResult.setText(String.format("%.2f", sum));
        }catch(NumberFormatException e){
            Alerts.showAlert("Error","Parse Error",e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}