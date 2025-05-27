package org.example.tsant.Controller;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import org.example.tsant.Model.Vehicle;


public class VehicleController {

    private Vehicle vehicle;
    private ImageView vehicleView; // Arabanın görsel temsili (JavaFX ImageView)

    public VehicleController(Vehicle vehicle, ImageView vehicleView) {
        this.vehicle = vehicle;
        this.vehicleView = vehicleView;
    }

    public void moveVehicle(Path path, int speedFactor) {
        PathTransition transition = new PathTransition();
        transition.setNode(vehicleView);
        transition.setPath(path);
        transition.setDuration(Duration.seconds(vehicle.getSpeed() / (double) speedFactor));
        transition.setCycleCount(1);
        transition.play();
    }

    public void updateSpeed(int newSpeed) {
        vehicle.setSpeed(newSpeed);
    }

    public boolean isVehicleArrived() {
        return vehicle.getPassed();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ImageView getVehicleView() {
        return vehicleView;
    }
}
