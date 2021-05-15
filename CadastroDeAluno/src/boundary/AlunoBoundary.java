<<<<<<< HEAD
package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import control.AlunoControl;
import entity.Aluno;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoBoundary extends Application implements EventHandler<ActionEvent> {

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
		Scene scn = new Scene(panel, 600, 200);

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

		btnAdicionar.setOnAction(this);
		btnPesquisar.setOnAction(this);

		stage.setScene(scn);
		stage.setTitle("Cadastro de Alunos");
		stage.show();

	}

	public void entityToBoundary(Aluno aluno) {
		txtId.setText(String.valueOf(aluno.getId()));
		txtRa.setText(aluno.getRa());
		txtNome.setText(aluno.getNome());
		txtDataNasc.setText(aluno.getDate().format(date));

	}

	public Aluno boundaryToEntity() {
		Aluno aluno = new Aluno();
		try {
			aluno.setId(Long.parseLong(txtId.getText()));
			aluno.setRa(txtRa.getText());
			aluno.setNome(txtNome.getText());
			aluno.setDate(LocalDate.parse(txtDataNasc.getText(), date));
		} catch (Exception e) {
			e.getStackTrace();
		}

		return aluno;
	}

	public void clearAll() {
		txtId.clear();
		txtRa.clear();
		txtNome.clear();
		txtDataNasc.clear();
	}

	@Override
	public void handle(ActionEvent event) {
		Aluno aluno;
		if (event.getSource() == btnAdicionar) {
			aluno = boundaryToEntity();
			control.adicionaAluno(aluno);
			clearAll();

		} else if (event.getSource() == btnPesquisar) {
			aluno = control.pesquisaPorNome(txtNome.getText());
			entityToBoundary(aluno);

		}

	}

	public static void main(String[] args) {

		Application.launch(AlunoBoundary.class, args);
	}

}
=======
package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import control.AlunoControl;
import entity.Aluno;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoBoundary extends Application implements EventHandler<ActionEvent> {

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
		Scene scn = new Scene(panel, 600, 200);

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

		btnAdicionar.setOnAction(this);
		btnPesquisar.setOnAction(this);

		stage.setScene(scn);
		stage.setTitle("Cadastro de Alunos");
		stage.show();

	}

	public void entityToBoundary(Aluno aluno) {
		txtId.setText(String.valueOf(aluno.getId()));
		txtRa.setText(aluno.getRa());
		txtNome.setText(aluno.getNome());
		txtDataNasc.setText(aluno.getDate().format(date));

	}

	public Aluno boundaryToEntity() {
		Aluno aluno = new Aluno();
		try {
			aluno.setId(Long.parseLong(txtId.getText()));
			aluno.setRa(txtRa.getText());
			aluno.setNome(txtNome.getText());
			aluno.setDate(LocalDate.parse(txtDataNasc.getText(), date));
		} catch (Exception e) {
			e.getStackTrace();
		}

		return aluno;
	}

	@Override
	public void handle(ActionEvent event) {
		Aluno aluno;
		if (event.getSource() == btnAdicionar) {
			aluno = boundaryToEntity();
			control.adicionaAluno(aluno);
			//entityToBoundary(new Aluno());

		} else if (event.getSource() == btnPesquisar) {
			aluno = control.pesquisaPorNome(txtNome.getText());
			entityToBoundary(aluno);

		}

	}

	public static void main(String[] args) {

		Application.launch(AlunoBoundary.class, args);
	}

}
>>>>>>> 283d044fe5ca1b6416da32bb067f2e7dfe669f1f
