package boundary;

import java.time.format.DateTimeFormatter;

import control.AlunoControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;

public class AlunoBoundary extends Application {

	TextField txtId = new TextField();
	TextField txtRa = new TextField();
	TextField txtNome = new TextField();
	TextField txtDataNasc = new TextField();
	Button btnAdicionar = new Button("Adicionar");
	Button btnPesquisar = new Button("Pesquisar");

	private DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private AlunoControl control = new AlunoControl();

	@Override
	public void start(Stage stage) throws Exception {

		GridPane panel = new GridPane();
		BorderPane panePrincipal = new BorderPane();
		Scene scn = new Scene(panePrincipal, 600, 200);

		panel.add(new Label("ID"), 0, 0);
		panel.add(new Label("RA"), 0, 1);
		panel.add(new Label("Nome"), 0, 2);
		panel.add(new Label("Data de Nascimento"), 0, 3);

		panel.add(txtId, 1, 0);
		panel.add(txtRa, 1, 1);
		panel.add(txtNome, 1, 2);
		panel.add(txtDataNasc, 1, 3);

		panel.add(btnAdicionar, 0, 4);
		panel.add(btnPesquisar, 1, 4);
		
		control.generateTable();
		panePrincipal.setTop(panel);
		panePrincipal.setCenter(control.getTable());

		btnAdicionar.setOnAction((e) -> {
			control.adicionaAluno();
		});
		btnPesquisar.setOnAction((e) -> {
			control.pesquisaPorNome();
		});

		StringConverter longToStringConverter = new LongStringConverter();
		StringConverter localDateToStringConverter = new LocalDateStringConverter();

		Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), longToStringConverter);
		Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtDataNasc.textProperty(), control.dateProperty(), localDateToStringConverter);

		stage.setScene(scn);
		stage.setTitle("Cadastro de Alunos");
		stage.show();

	}

	public static void main(String[] args) {

		Application.launch(AlunoBoundary.class, args);
	}

}
