package control;

import java.time.LocalDate;

import entity.Aluno;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoControl {

	private ObservableList<Aluno> alunos = FXCollections.observableArrayList();

	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty ra = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>(LocalDate.now());

	public void setEntity(Aluno a) {
		if (a != null) {
			id.set(a.getId());
			ra.set(a.getRa());
			nome.set(a.getNome());
			date.set(a.getDate());
		}
	}

	public Aluno getEntity() {
		Aluno a = new Aluno();

		a.setId(id.get());
		a.setRa(ra.get());
		a.setNome(nome.get());
		a.setDate(date.get());

		return a;

	}

	public void adicionaAluno() {
		Aluno a = getEntity();
		alunos.add(a);
		a = new Aluno();
		this.setEntity(a);
	}

	public void pesquisaPorNome() {

		for (Aluno a : alunos) {
			if (a.getNome().contains(nome.get())) {
				this.setEntity(a);
			}
		}

	}

	public long getId() {
		return id.get();
	}

	public LongProperty idProperty() {
		return id;
	}

	public StringProperty raProperty() {
		return ra;
	}

	public String getRa() {
		return ra.get();
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public String getNome() {
		return nome.get();
	}

	public ObjectProperty<LocalDate> dateProperty() {
		return date;
	}

	public LocalDate getDate() {
		return date.get();
	}

}
