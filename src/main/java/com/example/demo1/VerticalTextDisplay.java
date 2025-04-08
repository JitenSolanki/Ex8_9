package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

public class VerticalTextDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an HBox layout to arrange rotated texts horizontally
        HBox root = new HBox(30); // 30 pixels spacing between elements
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: white;");

        // Create five "Java" texts
        String[] textContents = {"Java", "Java", "Java", "Java", "Java"};
        Random random = new Random();

        for (String content : textContents) {
            // Create a new Text object
            Text text = new Text(content);

            // Set font to Times Roman, bold, italic, 22px
            text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));

            // Set random color with random opacity
            Color randomColor = Color.rgb(
                    random.nextInt(256),    // Red component (0-255)
                    random.nextInt(256),    // Green component (0-255)
                    random.nextInt(256),    // Blue component (0-255)
                    0.3 + random.nextDouble() * 0.7    // Opacity (0.3-1.0)
            );
            text.setFill(randomColor);

            // Rotate the text 90 degrees to make it vertical (bottom to top)
            text.setRotate(90);

            // Add the text to the HBox
            root.getChildren().add(text);
        }

        // Create and set the scene
        Scene scene = new Scene(root, 400, 100);
        primaryStage.setTitle("Experiment8_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}