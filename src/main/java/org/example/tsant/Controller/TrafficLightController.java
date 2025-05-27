package org.example.tsant.Controller;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TrafficLightController {

    public enum LightState {
        RED, YELLOW, GREEN
    }

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    private LightState currentState = LightState.RED;
    private Timeline timeline;

    @FXML
    public void initialize() {
        switchTo(LightState.RED); // Başlangıç durumu
        startSimulation();        // Otomatik geçişleri başlat
    }

    public void switchTo(LightState state) {
        this.currentState = state;

        // Işık durumlarını güncelle
        redLight.setOpacity(state == LightState.RED ? 1.0 : 0.3);
        yellowLight.setOpacity(state == LightState.YELLOW ? 1.0 : 0.3);
        greenLight.setOpacity(state == LightState.GREEN ? 1.0 : 0.3);
    }

    private void startSimulation() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame greenPhase = new KeyFrame(Duration.seconds(0), e -> switchTo(LightState.GREEN));
        KeyFrame yellowAfterGreen = new KeyFrame(Duration.seconds(5), e -> switchTo(LightState.YELLOW));
        KeyFrame redAfterYellow = new KeyFrame(Duration.seconds(7), e -> switchTo(LightState.RED));
        KeyFrame greenAgain = new KeyFrame(Duration.seconds(10)); // döngü başa sarar

        timeline.getKeyFrames().addAll(greenPhase, yellowAfterGreen, redAfterYellow, greenAgain);
        timeline.play();
    }

    public LightState getCurrentState() {
        return currentState;
    }

    public void stopSimulation() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    public void resumeSimulation() {
        if (timeline != null) {
            timeline.play();
        }
    }
}
