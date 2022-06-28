package com.example.calculosoma;

import com.example.calculosoma.gui.util.Alerts;
import com.example.calculosoma.gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txtNumberOne);
        Constraints.setTextFieldDouble(txtNumberTwo);
        Constraints.setTextFieldMaxLength(txtNumberOne,5);
        Constraints.setTextFieldMaxLength(txtNumberTwo,5);
    }
}