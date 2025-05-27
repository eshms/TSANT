package org.example.tsant.Model;


import java.awt.*;

public class Vehicle {
    private int speed;
    private String direction; //North, South, East, and West
    private boolean passed;//aracın geçip geçmediği kontrolü.
    private int position;// konum
    private String id;

    public Vehicle(String direction) {
        this.direction = direction;
        this.passed = false;//ilk olarak geçmedi olarak kabul edildi.
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction)  //aracın yönünü değiştirmek için yazıldı.
    {
        this.direction = direction;
    }

    public boolean getPassed() {
        return passed;
    }
    public void setPassed(boolean passed) //aracın geçme durumunu set etmek için.
    {
        this.passed = passed;
    }

    public void move() {

    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getSpeed(){
        return speed;
    }

    public int setSpeed(int speed){
        this.speed=speed;
        return speed;
    }

    public String getId() {
        return id;
    }

}
