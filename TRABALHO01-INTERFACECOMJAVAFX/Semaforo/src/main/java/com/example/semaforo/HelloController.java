package com.example.semaforo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HelloController {

    @FXML private Circle redLight;
    @FXML private Circle yellowLight;
    @FXML private Circle greenLight;

    private Timeline timeline;
    private int state = 0;

    @FXML
    public void start() {
        if (timeline != null && timeline.getStatus() == Timeline.Status.RUNNING)
            return;

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> switchLight()),
                new KeyFrame(Duration.seconds(2))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void stop() {
        if (timeline != null) timeline.stop();
        turnOff();
    }

    private void switchLight() {
        turnOff();
        switch (state) {
            case 0 -> redLight.setFill(Color.RED);
            case 1 -> yellowLight.setFill(Color.YELLOW);
            case 2 -> greenLight.setFill(Color.GREEN);
        }
        state = (state + 1) % 3;
    }

    private void turnOff() {
        redLight.setFill(Color.GRAY);
        yellowLight.setFill(Color.GRAY);
        greenLight.setFill(Color.GRAY);
    }
}
