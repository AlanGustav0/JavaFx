package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlunoControl {

	public static final String URL = "jdbc:mysql://localhost:3306/escola";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private ObservableList<Aluno> alunos = FXCollections.observableArrayList();

	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty ra = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>(LocalDate.now());
	private TableView<Aluno> table = new TableView<>();

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
		
		 //Adicionar apenas na lista 
		 
		 Aluno a = getEntity(); alunos.add(a); a = new
		 Aluno(); this.setEntity(a);
		 

		// Adicionando diretamente no Banco de Dados
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			System.out.println("Conectado ao banco de dados");

			String sql = "INSERT INTO TabAluno (matricula,ra,nome,data)" + "VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setLong(1, id.get());
			stmt.setString(2, ra.get());
			stmt.setString(3, nome.get());
			stmt.setDate(4, java.sql.Date.valueOf(date.get()));
			int i = stmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pesquisaPorNome() {

		/*
		 * Busca convêncional na lista for (Aluno a : alunos) { if
		 * (a.getNome().contains(nome.get())) { this.setEntity(a); } }
		 */

		// Busca no banco de dados
		alunos.clear();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

			String sql = "SELECT * FROM TabAluno WHERE nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome.get() + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();

				aluno.setId(rs.getLong("matricula"));
				aluno.setRa(rs.getString("ra"));
				aluno.setNome(rs.getString("nome"));
				aluno.setDate(rs.getDate("data").toLocalDate());
				this.setEntity(aluno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void generateTable() {
		TableColumn<Aluno, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Aluno, String> colRA = new TableColumn<>("RA");
		colRA.setCellValueFactory(new PropertyValueFactory<>("RA"));
		
		TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		
		TableColumn<Aluno, Date> colData = new TableColumn<>("Data");
		colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		
	
		
		table.getColumns().addAll(colId,colRA,colNome,colData);

		table.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
			this.setEntity(novo);
		});

		table.setItems(alunos);
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
	
	 public TableView<Aluno> getTable() {
	        return table;
	    }

}
