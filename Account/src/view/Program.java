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

public class Program extends Application {

	class ControllerAction implements EventHandler<MouseEvent> {

		Label lblTexto;
		String message;

		public ControllerAction(Label lblTexto, String message) {
			this.lblTexto = lblTexto;
			this.message = message;
		}

		@Override
		public void handle(MouseEvent event) {

			this.lblTexto.setText(message);

		}

	}

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

	@Override
	public void start(Stage stage) {

		Pane pane = new Pane();

		Account account = new Account();

		Scene principalScene = new Scene(pane, 600, 400);
		Button btn = new Button("Calculate");

		alignLabels();
		alignFields();

		inputNumber.textProperty()
				.addListener((observable) -> account.setNumber(Integer.parseInt(inputNumber.getText()))

				);

		inputHolder.textProperty().addListener(

				(observable) -> account.setHolder(inputHolder.getText()));

		inputBalance.textProperty().addListener((observable) -> {
			Double balance = Double.parseDouble(inputBalance.getText());
			account.deposit(balance);
		});

		lblWithDrawValue.setText(account.getWithDrawLimit().toString());

		inputAmount.textProperty().addListener((observable) -> {
			Double amount = Double.parseDouble(inputAmount.getText());
			account.withDraw(amount);
			String message = account.toString();

			btn.addEventFilter(MouseEvent.MOUSE_PRESSED, new ControllerAction(lblNewBalance, message));
		});

		/*
		 * inputBalance.textProperty().addListener(new ChangeListener<String>() {
		 * 
		 * @Override public void changed(ObservableValue<? extends String> observable,
		 * String oldValue, String newValue) { try { Double balance =
		 * Double.parseDouble(inputBalance.getText()); account.deposit(balance); } catch
		 * (Exception e) { lblMessage.setText("Type Error"); }
		 * 
		 * }
		 * 
		 * });
		 * 
		 * 
		 * inputNumber.textProperty().addListener(
		 * 
		 * (observable) -> lblResultado.setText(inputNumber.getText())
		 * 
		 * );
		 */
		btn.relocate(250, 350);

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
