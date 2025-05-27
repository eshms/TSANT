package org.example.tsant.Model;

public class TrafficLight {

    public enum State {
        RED, YELLOW, GREEN
    }

    private State currentState;

    public TrafficLight() {
        this.currentState = State.RED; // Başlangıçta kırmızı ışıkta başla
    }

    // Işık değiştir
    public void switchLight() {
        switch (currentState) {
            case RED -> currentState = State.GREEN;
            case GREEN -> currentState = State.YELLOW;
            case YELLOW -> currentState = State.RED;
        }
    }

    // Mevcut durumu döndür
    public State getCurrentState() {
        return currentState;
    }
}
