package sb223jy_assign2.exercise_7;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * NOTICE!
 * This implementation relies on that each png image of a dice is named faceN.png, e.g face1.png.
 * The pictures I used are included in the res folder.
 */

public class Yahtzee extends Application {
    private int rollsLeft = 3;
    private CheckBox[] checkBoxes = new CheckBox[5];
    private Dice[] dice = new Dice[5];
    private Image[] faces = new Image[6];
    private Label lblStatus = new Label("You have 3 rolls left.");
    private boolean disabled = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (int i = 0; i < 6; i++)
            faces[i] = new Image("face" + (i + 1) + ".png");

        for (int i = 0; i < 5; i++)
            dice[i] = new Dice(faces[i], (i + 1));

        GridPane root = new GridPane();

        Text txtTitle = new Text("Yahtzee");
        txtTitle.setFont(Font.font(25));
        GridPane.setHalignment(txtTitle, HPos.CENTER);

        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new CheckBox();
            checkBoxes[i].setDisable(true);
            GridPane.setHalignment(checkBoxes[i], HPos.CENTER);
            GridPane.setMargin(checkBoxes[i], new Insets(5, 0, 0,5));
        }

        Button btRoll = new Button("Roll the dice!");
        btRoll.setOnAction(e -> updateDice());
        GridPane.setMargin(btRoll, new Insets(5));
        GridPane.setMargin(lblStatus, new Insets(5));

        root.add(txtTitle, 0, 0, 5, 1);
        root.add(dice[0].getIvFace(), 0, 1);
        root.add(dice[1].getIvFace(), 1, 1);
        root.add(dice[2].getIvFace(), 2, 1);
        root.add(dice[3].getIvFace(), 3, 1);
        root.add(dice[4].getIvFace(), 4, 1);
        root.add(checkBoxes[0], 0, 2);
        root.add(checkBoxes[1], 1, 2);
        root.add(checkBoxes[2], 2, 2);
        root.add(checkBoxes[3], 3, 2);
        root.add(checkBoxes[4], 4, 2);
        root.add(btRoll, 0, 3, 2, 1);
        root.add(lblStatus, 2, 3, 3, 1);

        root.gridLinesVisibleProperty().setValue(false);
        root.hgapProperty().set(5);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Yahtzee");
        primaryStage.show();
    }

    private void updateDice() {
        if (disabled) {
            for (CheckBox cb : checkBoxes)
                cb.setDisable(false);
            disabled = false;
        }

        if (rollsLeft > 0) {
            rollsLeft--;
            for (int i = 0; i < 5; i++) {
                if (checkBoxes[i].isSelected()) {
                    dice[i].setLocked(true);
                }
            }

            for (int i = 0; i < 5; i++) {
                if (!dice[i].getStatus()) {
                    int n = (int) (Math.random() * 6);
                    dice[i].setFace(faces[n], (n + 1));
                }
            }

            lblStatus.setText("You have " + rollsLeft + " roll(s) left.");
        }
        if (rollsLeft == 0)
            calculateResult();
    }

    private void calculateResult() {
        int[] result = new int[5];
        int[] pattern = new int[5];

        for (int i = 0; i < 5; i++) {
            result[i] = dice[i].getNumber();
        }

        Arrays.sort(result);

        for (int j = 0, i = 0; j < result.length - 1; j = i) {
            while (i < (result.length - 1) && result[j] == result[++i]) {
                pattern[j]++;
            }
        }

        int threeOfAKind = 0;
        int fourOfAKind = 0;
        int total = 0;
        for (int n : pattern) {
            if (n == 2)
                threeOfAKind++;
            else if (n == 3)
                fourOfAKind++;
            total += n;
        }

        switch (total) {
            case 0: {
                if (result[0] == 1)
                    lblStatus.setText("Small Straight.");
                else if (result[0] == 2)
                    lblStatus.setText("Large Straight.");
            } break;
            case 1: {
                lblStatus.setText("Pair.");
                break;
            }
            case 2: {
                if (threeOfAKind > 0)
                    lblStatus.setText("Three of a kind.");
                else
                    lblStatus.setText("Double pair.");
                break;
            }
            case 3: {
                if (fourOfAKind > 0)
                    lblStatus.setText("Four of a kind.");
                else
                    lblStatus.setText("Full House.");
                break;
            }
            case 4: {
                lblStatus.setText("Yahtzee!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
