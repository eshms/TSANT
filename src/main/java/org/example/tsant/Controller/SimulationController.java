package org.example.tsant.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.control.Label;
public class SimulationController {

    @FXML
    private Rectangle northLight, southLight, eastLight, westLight;
    @FXML
    private Label northTimer, southTimer, eastTimer, westTimer;
    @FXML
    private Button startButton;

    @FXML
    private AnchorPane rootPane;  // Araçları çizmek için ana pane

    private Timeline timeline;
    private int currentPhase = 0;
    private int timeRemaining = 5;

    // Araçlar
    private Rectangle northCar, southCar, eastCar, westCar;

    public void initialize() {
        // Başlangıçta tüm ışıkları kırmızı yap
        setAllLights(Color.RED);

        // Araçları oluştur ve başlangıç pozisyonlarına koy
        northCar = createCar(Color.BLUE, 380, 0);   // üstten aşağı
        southCar = createCar(Color.GREEN, 420, 750); // alttan yukarı
        eastCar  = createCar(Color.ORANGE, 0, 380); // soldan sağa
        westCar  = createCar(Color.PURPLE, 750, 420); // sağdan sola

        rootPane.getChildren().addAll(northCar, southCar, eastCar, westCar);
    }

    private Rectangle createCar(Color color, double x, double y) {
        Rectangle car = new Rectangle(30, 15, color);
        car.setX(x);
        car.setY(y);
        return car;
    }

    @FXML
    private void startSimulation() {
        startButton.setDisable(true);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            updateLights();
            moveCars();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateLights() {
        if (timeRemaining == 0) {
            currentPhase = (currentPhase + 1) % 4;
            timeRemaining = 10;
        }

        switch (currentPhase) {
            case 0:
                setLight(northLight, northTimer, Color.GREEN, timeRemaining);
                setLight(southLight, southTimer, Color.GREEN, timeRemaining);
                setLight(eastLight, eastTimer, Color.RED, 0);
                setLight(westLight, westTimer, Color.RED, 0);
                break;
            case 1:
                setLight(northLight, northTimer, Color.YELLOW, timeRemaining);
                setLight(southLight, southTimer, Color.YELLOW, timeRemaining);
                setLight(eastLight, eastTimer, Color.RED, 0);
                setLight(westLight, westTimer, Color.RED, 0);
                break;
            case 2:
                setLight(northLight, northTimer, Color.RED, 0);
                setLight(southLight, southTimer, Color.RED, 0);
                setLight(eastLight, eastTimer, Color.GREEN, timeRemaining);
                setLight(westLight, westTimer, Color.GREEN, timeRemaining);
                break;
            case 3:
                setLight(northLight, northTimer, Color.RED, 0);
                setLight(southLight, southTimer, Color.RED, 0);
                setLight(eastLight, eastTimer, Color.YELLOW, timeRemaining);
                setLight(westLight, westTimer, Color.YELLOW, timeRemaining);
                break;
        }

        timeRemaining--;
    }

    private void setLight(Rectangle light, Label timer, Color color, int time) {
        light.setFill(color);
        timer.setText(time > 0 ? String.valueOf(time) : "");
    }

    private void setAllLights(Color color) {
        northLight.setFill(color);
        southLight.setFill(color);
        eastLight.setFill(color);
        westLight.setFill(color);
    }

    // Araç hareketini kontrol eden metot
    private void moveCars() {
        double step = 20; // her update'de 20px hareket

        // Kuzey-güney ışığı yeşil ise arabalar aşağı ve yukarı hareket eder, kırmızıda durur
        if (northLight.getFill() == Color.GREEN || southLight.getFill() == Color.GREEN) {
            // Kuzey arabası aşağı gider (y artar)
            if (northCar.getY() < 800) {
                northCar.setY(northCar.getY() + step);
            } else {
                northCar.setY(0);  // ekrandan çıkınca başa döner
            }
            // Güney arabası yukarı gider (y azalır)
            if (southCar.getY() > 0) {
                southCar.setY(southCar.getY() - step);
            } else {
                southCar.setY(800);
            }
        }

        // Doğu-batı ışığı yeşil ise arabalar sağa ve sola hareket eder, kırmızıda durur
        if (eastLight.getFill() == Color.GREEN || westLight.getFill() == Color.GREEN) {
            // Doğu arabası sağa gider (x artar)
            if (eastCar.getX() < 800) {
                eastCar.setX(eastCar.getX() + step);
            } else {
                eastCar.setX(0);
            }
            // Batı arabası sola gider (x azalır)
            if (westCar.getX() > 0) {
                westCar.setX(westCar.getX() - step);
            } else {
                westCar.setX(800);
            }
        }
    }
}
