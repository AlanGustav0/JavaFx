package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane panel = new FlowPane();
        panel.setAlignment(Pos.TOP_CENTER);
        panel.setHgap(20);
        panel.setVgap(20);

        Scene scn = new Scene(panel, 335.0, 290.0);

        TextField textValues = new TextField();
        Button btnCe = new Button("CE");
        Button btnOne = new Button("1");
        Button btnTwo = new Button("2");
        Button btnThree = new Button("3");
        Button btnPlus = new Button("+");
        Button btnFour = new Button("4");
        Button btnFive = new Button("5");
        Button btnSix = new Button("6");
        Button btnSub = new Button("-");
        Button btnSeven = new Button("7");
        Button btnEight = new Button("8");
        Button btnNine = new Button("9");
        Button btnMult = new Button("x");
        Button btnZero = new Button("0");
        Button btnEqual = new Button("=");
        Button btnDiv = new Button("/");
        Button btnComma = new Button(",");


        textValues.relocate(30.0, 30.0);
        textValues.setPrefColumnCount(18);

        btnCe.relocate(260.0, 30.0);
        btnCe.setPrefWidth(60.0);
        btnCe.setFont(Font.font(15));

        btnOne.relocate(20.0, 70.0);
        btnOne.setPrefWidth(60.0);
        btnOne.setPrefHeight(40.0);
        btnOne.setFont(Font.font(15));

        btnTwo.relocate(100.0, 70.0);
        btnTwo.setPrefWidth(60.0);
        btnTwo.setPrefHeight(40.0);
        btnTwo.setFont(Font.font(15));

        btnThree.relocate(180.0, 70.0);
        btnThree.setPrefWidth(60.0);
        btnThree.setPrefHeight(40.0);
        btnThree.setFont(Font.font(15));

        btnPlus.relocate(260.0, 70.0);
        btnPlus.setPrefWidth(60.0);
        btnPlus.setPrefHeight(40.0);
        btnPlus.setFont(Font.font(15));

        btnFour.relocate(20.0, 120.0);
        btnFour.setPrefWidth(60.0);
        btnFour.setPrefHeight(40.0);
        btnFour.setFont(Font.font(15));

        btnFive.relocate(100.0, 120.0);
        btnFive.setPrefWidth(60.0);
        btnFive.setPrefHeight(40.0);
        btnFive.setFont(Font.font(15));

        btnSix.relocate(180.0, 120.0);
        btnSix.setPrefWidth(60.0);
        btnSix.setPrefHeight(40.0);
        btnSix.setFont(Font.font(15));

        btnSub.relocate(260.0, 120.0);
        btnSub.setPrefWidth(60.0);
        btnSub.setPrefHeight(40.0);
        btnSub.setFont(Font.font(15));

        btnSeven.relocate(20.0, 170.0);
        btnSeven.setPrefWidth(60.0);
        btnSeven.setPrefHeight(40.0);
        btnSeven.setFont(Font.font(15));

        btnEight.relocate(100.0, 170.0);
        btnEight.setPrefWidth(60.0);
        btnEight.setPrefHeight(40.0);
        btnEight.setFont(Font.font(15));

        btnNine.relocate(180.0, 170.0);
        btnNine.setPrefWidth(60.0);
        btnNine.setPrefHeight(40.0);
        btnNine.setFont(Font.font(15));

        btnMult.relocate(260.0, 170.0);
        btnMult.setPrefWidth(60.0);
        btnMult.setPrefHeight(40.0);
        btnMult.setFont(Font.font(15));

        btnZero.relocate(100.0, 220.0);
        btnZero.setPrefWidth(60.0);
        btnZero.setPrefHeight(40.0);
        btnZero.setFont(Font.font(15));

        btnEqual.relocate(180.0, 220.0);
        btnEqual.setPrefWidth(60.0);
        btnEqual.setPrefHeight(40.0);
        btnEqual.setFont(Font.font(15));

        btnDiv.relocate(260.0, 220.0);
        btnDiv.setPrefWidth(60.0);
        btnDiv.setPrefHeight(40.0);
        btnDiv.setFont(Font.font(15));

        btnComma.relocate(20.0, 220.0);
        btnComma.setPrefWidth(60.0);
        btnComma.setPrefHeight(40.0);
        btnComma.setFont(Font.font(15));

        panel.getChildren().addAll(textValues,btnCe,btnOne,btnTwo, btnThree, btnPlus, btnFour,
                btnSeven, btnComma, btnFive, btnEight,btnZero,btnSix,btnSub,btnNine,btnEqual,btnMult,btnDiv);


        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scn);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
