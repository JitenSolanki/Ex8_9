package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Experiment9_1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create main components
        Label displayLabel = new Label("Programming is fun");
        displayLabel.setStyle("-fx-font-size: 48px; -fx-font-family: 'Book Antiqua';");

        // Font name selection
        ComboBox<String> fontNameComboBox = new ComboBox<>();
        fontNameComboBox.getItems().addAll(Font.getFamilies());
        fontNameComboBox.setValue("Book Antiqua");
        fontNameComboBox.setPrefWidth(300);

        // Font size selection
        ComboBox<Integer> fontSizeComboBox = new ComboBox<>();
        for (int i = 1; i <= 100; i++) {
            fontSizeComboBox.getItems().add(i);
        }
        fontSizeComboBox.setValue(48);
        fontSizeComboBox.setPrefWidth(100);

        // Style checkboxes
        CheckBox boldCheckBox = new CheckBox("Bold");
        CheckBox italicCheckBox = new CheckBox("Italic");

        // Create layout
        HBox topBox = new HBox(10, new Label("Font Name"), fontNameComboBox,
                new Label("Font Size"), fontSizeComboBox);

        HBox bottomBox = new HBox(10, boldCheckBox, italicCheckBox);
        bottomBox.setAlignment(Pos.CENTER);

        // Create the display area
        StackPane displayPane = new StackPane(displayLabel);
        displayPane.setPadding(new Insets(15));

        // Setup main layout
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(displayPane);
        root.setBottom(bottomBox);
        root.setPadding(new Insets(10));

        // Event handlers - use one handler for all components
        Runnable updateFont = () -> {
            StringBuilder style = new StringBuilder();
            style.append("-fx-font-family: '").append(fontNameComboBox.getValue()).append("'; ");
            style.append("-fx-font-size: ").append(fontSizeComboBox.getValue()).append("px; ");
            style.append("-fx-font-weight: ").append(boldCheckBox.isSelected() ? "bold" : "normal").append("; ");
            style.append("-fx-font-style: ").append(italicCheckBox.isSelected() ? "italic" : "normal");
            displayLabel.setStyle(style.toString());
        };

        // Attach the handler to all controls
        fontNameComboBox.setOnAction(e -> updateFont.run());
        fontSizeComboBox.setOnAction(e -> updateFont.run());
        boldCheckBox.setOnAction(e -> updateFont.run());
        italicCheckBox.setOnAction(e -> updateFont.run());

        // Create and show the scene
        Scene scene = new Scene(root, 600, 200);
        primaryStage.setTitle("Experiment9_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}