package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.entity.Account;
import model.exceptions.ErrorBalanceException;
import model.exceptions.NotEnoughBalance;

public class Program extends Application {

	static TextField inputNumber = new TextField();
	static TextField inputHolder = new TextField();
	static TextField inputBalance = new TextField();
	static Label lblWithDrawValue = new Label();
	static TextField inputAmount = new TextField();
	static Label lblNewBalance = new Label();

	static Label lblNumber = new Label("Number");
	static Label lblHolder = new Label("Holder");
	static Label lblInitialBalance = new Label("InitialBalance");
	static Label lblWithDraw = new Label("Withdraw limit");
	static Label lblMessageAmount = new Label("Enter amount for withdraw");
	static Label lblMessage = new Label();
	static Button btn = new Button("Calculate");

	@Override
	public void start(Stage stage) {

		Pane pane = new Pane();

		Account account = new Account();

		Scene principalScene = new Scene(pane, 600, 350);

		alignLabels();
		alignFields();

		inputNumber.textProperty().addListener((observable) -> {
			try {
				account.setNumber(Integer.parseInt(inputNumber.getText()));
				lblMessage.setText("");
			} catch (NumberFormatException e) {
				lblMessage.setText("Error, invalid format!");
			}
		}

		);

		inputHolder.textProperty().addListener(

				(observable) -> account.setHolder(inputHolder.getText()));

		lblWithDrawValue.setText(account.getWithDrawLimit().toString());

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				try {
					Double depositBalance = Double.parseDouble(inputBalance.getText());
					Double amount = Double.parseDouble(inputAmount.getText());

					account.validateWithDraw(amount);
					account.deposit(depositBalance);
					account.withDraw(amount);

					lblMessage.setText(account.toString());
				} catch (ErrorBalanceException e) {
					lblMessage.setText(e.getMessage());
				} catch (NotEnoughBalance e) {
					lblMessage.setText(e.getMessage());
				}
			}

		};

		btn.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);

		pane.getChildren().addAll(inputNumber, inputHolder, inputBalance, lblWithDrawValue, inputAmount, lblNewBalance,
				lblNumber, lblHolder, lblInitialBalance, lblWithDraw, lblMessageAmount, lblMessage, btn);

		stage.setTitle("Account System");
		stage.setScene(principalScene);
		stage.sizeToScene();
		stage.show();

	}

	public static void alignLabels() {
		int x = 10;

		lblNumber.relocate(x, 20);
		lblHolder.relocate(x, 60);
		lblInitialBalance.relocate(x, 100);
		lblWithDraw.relocate(x, 140);
		lblMessageAmount.relocate(x, 180);
		lblMessage.relocate(x, 240);
		lblNewBalance.relocate(x, 220);
		btn.relocate(250, 300);

	}

	public static void alignFields() {
		int x = 180;
		int y = 20;

		inputNumber.relocate(x, y);
		inputHolder.relocate(x, 60);
		inputBalance.relocate(x, 100);
		lblWithDrawValue.relocate(x, 140);
		inputAmount.relocate(x, 180);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
