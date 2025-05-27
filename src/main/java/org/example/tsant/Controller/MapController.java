package org.example.tsant.Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.example.tsant.Model.TrafficLight;

public class MapController {

    @FXML
    private Pane mapPane;

    private TrafficLightController trafficLightController;

    @FXML
    public void initialize() {
        trafficLightController = new TrafficLightController();

        // Örnek olarak: Map yüklendiğinde trafik ışığını initialize et
        System.out.println("Map yüklendi. Trafik ışığı kontrolörü oluşturuldu.");
    }

    // Trafik ışığını dışarıdan tetiklemek için kullanılabilir
    public TrafficLightController getTrafficLightController() {
        return trafficLightController;
    }
}
