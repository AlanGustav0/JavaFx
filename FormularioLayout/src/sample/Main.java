package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Scene scn = new Scene(gridPane,600.0,200.0);

        Label lblId = new Label("Id");
        gridPane.add(lblId,1,1);

        TextField textId = new TextField();
        textId.setPromptText("Entre com Id");
        textId.setPrefColumnCount(40);
        gridPane.add(textId,2,1);


        Label lblNome = new Label("Nome");
        gridPane.add(lblNome,1,2);

        TextField textNome = new TextField();
        textNome.setPromptText("Digite seu nome");
        textNome.setPrefColumnCount(40);
        gridPane.add(textNome,2,2);

        Label lblTelefone = new Label("Telefone");
        gridPane.add(lblTelefone,1,3);

        TextField textTelefone = new TextField();
        textTelefone.setPromptText("Digite seu telefone");
        textTelefone.setPrefColumnCount(40);
        gridPane.add(textTelefone,2,3);


        Button btnSalvar = new Button("Salvar");
        gridPane.add(btnSalvar,1,4);
        Button btnPesquisar = new Button("Pesquisar");
        gridPane.add(btnPesquisar,2,4);

        String locateIcon = "sample/icon.png";
        primaryStage.getIcons().add(new Image(locateIcon));
        primaryStage.setTitle("Formulário");
        primaryStage.setScene(scn);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
