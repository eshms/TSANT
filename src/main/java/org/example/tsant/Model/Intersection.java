package org.example.tsant.Model;

import java.util.LinkedList;
import java.util.Queue;

public class Intersection {
    private final Queue<Vehicle> vehicles = new LinkedList<>();
    private String currentLight = "GREEN";
    private int timer = 5;
    private String Id;

    public void addVehicle(Vehicle v) {
        vehicles.offer(v);
    }

    public void updateLights() {
        timer--;
        if (timer <= 0) {
            currentLight = currentLight.equals("GREEN") ? "RED" : "GREEN";
            timer = 5;
        }
    }

    public void moveVehicles() {
        if (currentLight.equals("GREEN") && !vehicles.isEmpty()) {
            Vehicle passed = vehicles.poll();
            System.out.println(passed.getId() + " geçti.");
        }
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    @Override
    public String toString() {
        return "Işık: " + currentLight + ", Araç sayısı: " + vehicles.size();
    }
}
