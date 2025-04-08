package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GradeBarChart extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(0); // spacing between bars
        root.setStyle("-fx-padding: 20; -fx-background-color: white; -fx-alignment: bottom-left;");

        // Bar data: label, percent, color
        root.getChildren().add(createBar("Project", 0.2, Color.RED));
        root.getChildren().add(createBar("Quiz", 0.1, Color.BLUE));
        root.getChildren().add(createBar("Midterm", 0.3, Color.GREEN));
        root.getChildren().add(createBar("Final", 0.4, Color.ORANGE));

        Scene scene = new Scene(root, 350, 200);
        primaryStage.setTitle("Experiment8_2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create individual bar with label on top
    private VBox createBar(String label, double percent, Color color) {
        VBox box = new VBox(5);
        box.setStyle("-fx-alignment: bottom-center;");

        double maxHeight = 200;
        Rectangle bar = new Rectangle(70, percent * maxHeight);
        bar.setFill(color);

        Text text = new Text(label + " -- " + (int)(percent * 100) + "%");

        // Add label above the bar
        box.getChildren().addAll(text, bar);
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
