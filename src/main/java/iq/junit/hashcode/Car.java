package iq.junit.hashcode;

import java.util.Objects;

public class Car {

    private final int id;
    private int currentX;
    private int currentY;

    public Car(int id){
        this.id = id;
        this.currentX = 0;
        this.currentY = 0;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getRideValue(Ride ride){
        int d1 = HelperMethods.getDistance(currentX, currentY, ride.getStartX(), ride.getStartY());
        int w = ride.getEarliestStart() - d1;
        if(w > 0){
            return d1 + ride.getRideDistance() + w;
        }else{
            return d1 + ride.getRideDistance();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "currentX=" + currentX +
                ", currentY=" + currentY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return id == car.id &&
                getCurrentX() == car.getCurrentX() &&
                getCurrentY() == car.getCurrentY();
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, getCurrentX(), getCurrentY());
    }
}
