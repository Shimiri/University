package sb223jy_assign2.exercise_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompoundInterest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text txt = new Text("Compound Interest");
        txt.setFont(Font.font(20));

        TextField tfStartAmount = new TextField();
        tfStartAmount.setPrefSize(150, 5);

        Label lblStartAmount = new Label("Start amount: ");
        lblStartAmount.setAlignment(Pos.BOTTOM_LEFT);
        lblStartAmount.setPadding(new Insets(5, 0, 0, 5));

        TextField tfInterest = new TextField();
        tfInterest.setPrefSize(150, 5);

        Label lblInterest = new Label("Interest: ");
        lblInterest.setAlignment(Pos.BOTTOM_LEFT);
        lblInterest.setPadding(new Insets(5, 0, 0, 5));

        TextField tfYears = new TextField();
        tfYears.setPrefSize(150, 5);

        Label lblYears = new Label("Number of years: ");
        lblYears.setAlignment(Pos.BOTTOM_LEFT);
        lblYears.setPadding(new Insets(5, 0, 0, 5));

        Label lblTotal = new Label();
        lblTotal.setPadding(new Insets(5, 0, 5, 5));

        Button btnCalculate = new Button("Calculate");
        btnCalculate.setOnAction(e -> {
            if (!tfStartAmount.getText().isEmpty() && !tfInterest.getText().isEmpty() && !tfYears.getText().isEmpty()) {
                double futureValue = Double.parseDouble(tfStartAmount.getText())
                        * Math.pow(1 + Double.parseDouble(tfInterest.getText()) / 100, Double.parseDouble(tfYears.getText()));
                lblTotal.setText("In total that will be " + (int) futureValue);
            }
        });

        GridPane root = new GridPane();
        root.add(txt, 0, 0, 2, 1);
        root.add(lblStartAmount, 0, 1);
        root.add(tfStartAmount, 1, 1);
        root.add(lblInterest, 0, 2);
        root.add(tfInterest, 1, 2);
        root.add(lblYears, 0, 3);
        root.add(tfYears, 1, 3);
        root.add(btnCalculate, 0, 4);
        root.add(lblTotal, 0, 5, 2, 1);

        Scene s = new Scene(root);

        primaryStage.setTitle("Compound Interest");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
