package view.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

	public TextField inputNumber = new TextField();

	public TextField inputHolder = new TextField();

	public TextField inputBalance = new TextField();

	public TextField inputWithDraw = new TextField();

	public TextField inputAmountMessage = new TextField();

	public TextField inputNewBalance = new TextField();

	public Label lblNumber = new Label("Number");

	public Label lblHolder = new Label("Holder");

	public Label lblInitialBalance = new Label("InitialBalance");

	public Label lblWithDraw = new Label("Withdraw limit");

	public Label lblMessageAmount = new Label("Enter amount for withdrawa");

	public Label lblBalance = new Label("New balance");

	public Label lblResultado = new Label("Resultado");

	public Controller() {

	}

	public Controller(Label lblResultado, TextField inputNumber) {
		this.lblResultado = lblResultado;
		this.inputNumber = inputNumber;
	}

	public void handle() {
		//lblResultado.setText(inputNumber.getText());
		
		inputNumber.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				lblResultado.setText(inputNumber.getText());

			}

		});
	}

	
	

}
