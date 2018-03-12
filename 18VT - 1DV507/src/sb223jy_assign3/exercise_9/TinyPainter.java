package sb223jy_assign3.exercise_9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TinyPainter extends Application {
    private String shape = "Line";
    private Color color = Color.BLACK;
    private ColorPicker colorPicker;
    private double size = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(event -> {
            color = colorPicker.getValue();
        });

        ComboBox<String> cbShape = new ComboBox();
        ComboBox<Double> cbSize = new ComboBox();

        ObservableList<Double> sizes = FXCollections.observableArrayList();
        for (double i = 0; i < 40; i++)
            sizes.add((i + 1));

        cbShape.setPrefWidth(150);
        cbSize.setPrefWidth(90);

        cbSize.setItems(sizes);
        cbSize.getSelectionModel().selectFirst();
        cbSize.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
            size = Double.parseDouble(observable.getValue().toString());
        });

        cbShape.setItems(FXCollections.observableArrayList("Line", "Dot", "Rectangle", "Circle"));
        cbShape.getSelectionModel().selectFirst();
        cbShape.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
            shape = observable.getValue();
        });

        HBox buttonRow = new HBox();
        buttonRow.setSpacing(5);
        buttonRow.getChildren().addAll(cbShape, cbSize, colorPicker);

        Pane canvas = new Pane();
        canvas.setPrefHeight(400);
        canvas.setPrefWidth(700);

        canvas.setOnMousePressed(mousePress -> {
            if (shape.equals("Line")) {
                Line line = new Line();
                canvas.getChildren().add(line);
                line.setStrokeWidth(size);
                line.setStroke(color);
                line.setStartX(mousePress.getX());
                line.setStartY(mousePress.getY());
                line.setEndX(mousePress.getX());
                line.setEndY(mousePress.getY());
                canvas.setOnMouseDragged(mouseDrag -> {
                    line.setEndY(mouseDrag.getY());
                    line.setEndX(mouseDrag.getX());
                });
            }
            else if (shape.equals("Dot")) {
                Line dot = new Line();
                canvas.getChildren().add(dot);
                dot.setStrokeWidth(size);
                dot.setStroke(color);
                dot.setStartX(mousePress.getX());
                dot.setStartY(mousePress.getY());
                dot.setEndX(mousePress.getX());
                dot.setEndY(mousePress.getY());
                canvas.setOnMouseDragged(mouseDrag -> {

                });
            }
            else if (shape.equals("Rectangle")) {
                Rectangle rect = new Rectangle();
                canvas.getChildren().add(rect);
                rect.setFill(color);
                rect.setX(mousePress.getX());
                rect.setY(mousePress.getY());
                canvas.setOnMouseDragged(mouseDrag -> {
                    rect.setHeight(mouseDrag.getY() - rect.getY());
                    rect.setWidth(mouseDrag.getX() - rect.getX());
                });
            }
            else if (shape.equals("Circle")) {
                Circle circle = new Circle();
                canvas.getChildren().add(circle);
                circle.setFill(color);
                circle.setCenterX(mousePress.getX());
                circle.setCenterY(mousePress.getY());
                canvas.setOnMouseDragged(mouseDrag -> {
                    double r = mouseDrag.getX() - circle.getCenterX();
                    if (r < 0)
                        r = -r;
                    circle.setRadius(r);
                });
            }
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(buttonRow, canvas);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
