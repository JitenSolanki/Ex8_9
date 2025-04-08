package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ResizableCuboid extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();

        // 12 lines: 4 for front, 4 for back, 4 for connections
        Line[] lines = new Line[12];
        for (int i = 0; i < 12; i++) {
            lines[i] = new Line();
            root.getChildren().add(lines[i]);
        }

        // Scene with width & height
        Scene scene = new Scene(root, 400, 400);

        // Initial drawing
        updateLines(lines, scene.getWidth(), scene.getHeight());

        // Resize handling: redraw when window size changes
        scene.widthProperty().addListener((obs, oldVal, newVal) ->
                updateLines(lines, newVal.doubleValue(), scene.getHeight()));

        scene.heightProperty().addListener((obs, oldVal, newVal) ->
                updateLines(lines, scene.getWidth(), newVal.doubleValue()));

        stage.setTitle("Experiment8_3");
        stage.setScene(scene);
        stage.show();
    }

    // Method to update line positions based on window size
    private void updateLines(Line[] l, double w, double h) {
        // Front face top-left corner (fx, fy), width and height (fw, fh)
        double fx = w * 0.2;
        double fy = h * 0.2;
        double fw = w * 0.4;
        double fh = h * 0.4;

        // Back face offset a bit diagonally
        double bx = fx + w * 0.15;
        double by = fy + h * 0.15;

        // Front face (4 lines)
        l[0].setStartX(fx);         l[0].setStartY(fy);
        l[0].setEndX(fx + fw);      l[0].setEndY(fy);

        l[1].setStartX(fx + fw);    l[1].setStartY(fy);
        l[1].setEndX(fx + fw);      l[1].setEndY(fy + fh);

        l[2].setStartX(fx + fw);    l[2].setStartY(fy + fh);
        l[2].setEndX(fx);           l[2].setEndY(fy + fh);

        l[3].setStartX(fx);         l[3].setStartY(fy + fh);
        l[3].setEndX(fx);           l[3].setEndY(fy);

        // Back face (4 lines)
        l[4].setStartX(bx);         l[4].setStartY(by);
        l[4].setEndX(bx + fw);      l[4].setEndY(by);

        l[5].setStartX(bx + fw);    l[5].setStartY(by);
        l[5].setEndX(bx + fw);      l[5].setEndY(by + fh);

        l[6].setStartX(bx + fw);    l[6].setStartY(by + fh);
        l[6].setEndX(bx);           l[6].setEndY(by + fh);

        l[7].setStartX(bx);         l[7].setStartY(by + fh);
        l[7].setEndX(bx);           l[7].setEndY(by);

        // Connecting lines (front to back)
        l[8].setStartX(fx);         l[8].setStartY(fy);
        l[8].setEndX(bx);           l[8].setEndY(by);

        l[9].setStartX(fx + fw);    l[9].setStartY(fy);
        l[9].setEndX(bx + fw);      l[9].setEndY(by);

        l[10].setStartX(fx + fw);   l[10].setStartY(fy + fh);
        l[10].setEndX(bx + fw);     l[10].setEndY(by + fh);

        l[11].setStartX(fx);        l[11].setStartY(fy + fh);
        l[11].setEndX(bx);          l[11].setEndY(by + fh);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
