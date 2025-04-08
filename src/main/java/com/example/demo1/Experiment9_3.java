package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Experiment9_3 extends Application {

    private TextField tfSpeed = new TextField("1000");
    private TextField tfPrefix = new TextField("L");
    private TextField tfNumberOfImages = new TextField("1");
    private TextField tfURL = new TextField("https://www2.cs.uic.edu/~i101/SoundFiles/StarWars60.wav");

    private StackPane paneForImage = new StackPane();
    private Timeline animation;
    private int currentIndex = 1;

    @Override
    public void start(Stage primaryStage) {
        paneForImage.setPrefSize(400, 300);

        GridPane inputGrid = new GridPane();
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(10));

        inputGrid.add(new Label("Animation speed in milliseconds:"), 0, 0);
        inputGrid.add(tfSpeed, 1, 0);

        inputGrid.add(new Label("Image file prefix:"), 0, 1);
        inputGrid.add(tfPrefix, 1, 1);

        inputGrid.add(new Label("Number of images:"), 0, 2);
        inputGrid.add(tfNumberOfImages, 1, 2);

        inputGrid.add(new Label("Audio file URL:"), 0, 3);
        inputGrid.add(tfURL, 1, 3);

        Button btnStart = new Button("Start Animation");

        BorderPane root = new BorderPane();
        root.setTop(btnStart);
        BorderPane.setAlignment(btnStart, Pos.TOP_RIGHT);
        root.setCenter(paneForImage);
        root.setBottom(inputGrid);

        btnStart.setOnAction(e -> {
            int speed = Integer.parseInt(tfSpeed.getText());
            int totalImages = Integer.parseInt(tfNumberOfImages.getText());
            String prefix = tfPrefix.getText();
            String url = tfURL.getText();

            if (animation != null) animation.stop();
            animation = new Timeline(new KeyFrame(Duration.millis(speed), ev -> nextImage(prefix, totalImages)));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();

            // Play audio
            try {
                Media media = new Media(url);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            } catch (Exception ex) {
                System.out.println("Audio Error: " + ex.getMessage());
            }
        });

        // Display first image
        getImage("L", 1);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Practical 8-B-3 - JavaFX Animation");
        primaryStage.show();
    }

    private void nextImage(String prefix, int totalImages) {
        currentIndex = (currentIndex < totalImages) ? currentIndex + 1 : 1;
        getImage(prefix, currentIndex);
    }

    private void getImage(String prefix, int number) {
        String path = "images/" + prefix + number + ".png";
        File file = new File(path);
        if (file.exists()) {
            Image img = new Image(file.toURI().toString());
            ImageView view = new ImageView(img);
            view.setFitWidth(300);
            view.setFitHeight(300);
            paneForImage.getChildren().setAll(view);
        } else {
            System.out.println("Image not found: " + path);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
