package org.example.tsant.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ButtonsController {

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button addVehicleButton;

    // Bu metodlar FXML dosyasında fx:id ve onAction ile eşleştirilmelidir.

    @FXML
    private void handleStartButton() {
        System.out.println("Simülasyon başlatıldı.");
        // Simülasyonu başlatacak controller ya da model sınıfı çağrılabilir
    }

    @FXML
    private void handleStopButton() {
        System.out.println("Simülasyon durduruldu.");
        // Simülasyonu durduracak kod buraya
    }

    @FXML
    private void handleAddVehicleButton() {
        System.out.println("Yeni araç eklendi.");
        // Yeni araç ekleme işlemi (örneğin bir VehicleController çağrısı)
    }
}
