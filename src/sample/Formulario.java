package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Formulario extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane painel = new Pane();
        Scene scn = new Scene(painel,650.,200.0);
        Label lblId = new Label("Id");
        Label lblNome = new Label("Nome");
        Label lblTelefone = new Label("Telefone");
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        TextField textId = new TextField();
        textId.setPromptText("Entre com Id");
        textId.setPrefColumnCount(40);

        TextField textNome = new TextField();
        textNome.setPromptText("Digite seu nome");
        textNome.setPrefColumnCount(40);

        TextField textTelefone = new TextField();
        textTelefone.setPromptText("Digite seu telefone");
        textTelefone.setPrefColumnCount(40);


        lblId.relocate(20.0,20.0);
        lblNome.relocate(20.0,60.0);
        lblTelefone.relocate(20.0,100.0);
        btnSalvar.relocate(20.0,130.0);
        btnPesquisar.relocate(80.0,130.0);
        textId.relocate(150.0,20.0);
        textNome.relocate(150.0,60.0);
        textTelefone.relocate(150.0,100.0);


        painel.getChildren().addAll(lblId,lblNome,lblTelefone,btnSalvar,
                btnPesquisar,textId,textNome,textTelefone);


        primaryStage.setResizable(false);
        primaryStage.setTitle("Formulário de inscrição");
        primaryStage.setScene(scn);

        primaryStage.sizeToScene();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
