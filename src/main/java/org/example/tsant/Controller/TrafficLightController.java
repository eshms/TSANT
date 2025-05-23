package org.example.tsant.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.tsant.Model.TrafficLight;
import static java.awt.Color.*;

public class TrafficLightController {

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    @FXML
    private Label statusLabel;

    private TrafficLight trafficLight;

    @FXML
    public void initialize() {
        trafficLight = new TrafficLight(); // Model nesnesini oluştur

        updateLights(); // Başlangıç durumu
    }

    public void changeLight() {
        trafficLight.switchLight(); // Modelde ışığı değiştir
        updateLights();             // View güncelle
    }

    private void updateLights() {
        switch (trafficLight.getCurrentState()) {
            case RED -> {
                redLight.setFill(Color.RED);
                yellowLight.setFill(Color.GRAY);
                greenLight.setFill(Color.GRAY);
                statusLabel.setText("DUR");
            }
            case YELLOW -> {
                redLight.setFill(Color.GRAY);
                yellowLight.setFill(Color.YELLOW);
                greenLight.setFill(Color.GRAY);
                statusLabel.setText("DİKKAT");
            }
            case GREEN -> {
                redLight.setFill(Color.GRAY);
                yellowLight.setFill(Color.GRAY);
                greenLight.setFill(Color.LIMEGREEN);
                statusLabel.setText("GEÇ");
            }
        }
    }
}
