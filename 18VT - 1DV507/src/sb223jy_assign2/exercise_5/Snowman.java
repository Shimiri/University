package sb223jy_assign2.exercise_5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Snowman extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 500, 400);
        gc.setFill(Color.WHITE);
        gc.fillOval(200, 310, 100, 100);
        gc.fillOval(210, 250, 75, 75);
        gc.fillOval(225, 210, 50, 50);
        gc.setFill(Color.BLACK);
        gc.fillOval(245, 260, 10, 10);
        gc.fillOval(245, 280, 10, 10);
        gc.fillOval(245, 300, 10, 10);
        gc.fillOval(235, 230, 7, 7);
        gc.fillOval(260, 230, 7, 7);
        gc.setLineWidth(3);
        gc.strokeLine(240, 245, 260, 245);
        gc.setFill(Color.YELLOW);
        gc.fillOval(350, 50, 120, 120);
        gc.setLineWidth(5);
        gc.setFill(Color.BLACK);
        gc.strokeLine(225, 210, 275, 210);
        gc.fillRect(235, 180, 30, 30);


        Scene scene = new Scene(root, 500, 500);

        root.getChildren().add(canvas);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snowman");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
