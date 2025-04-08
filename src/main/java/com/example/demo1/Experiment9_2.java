package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Experiment9_2 extends Application {
    private double x = 20; // Initial x position of the text
    private boolean isPaused = false;

    @Override
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        // Create a text
        Text text = new Text(x, 100, "Programming is fun");
        text.setFont(Font.font(20));
        pane.getChildren().add(text);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Experiment9_2");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a timeline for animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50), e -> {
                    if (!isPaused) {
                        // Move the text
                        x += 5;

                        // Check if the text has moved beyond the right edge
                        if (x > scene.getWidth()) {
                            // Reset the position to the left edge
                            x = -text.getBoundsInLocal().getWidth();
                        }

                        // Update text position
                        text.setX(x);
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Handle mouse events
        scene.setOnMousePressed(e -> isPaused = true);
        scene.setOnMouseReleased(e -> isPaused = false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
