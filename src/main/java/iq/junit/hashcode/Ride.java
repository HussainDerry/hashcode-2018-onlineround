package iq.junit.hashcode;

import java.util.Objects;

public class Ride{

    private final int id;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final int earliestStart;
    private final int latestFinish;

    public Ride(int id, int startX, int startY, int endX, int endY, int earliestStart, int latestFinish) {
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public int getRideDistance(){
        return Math.abs(endX - startX) + Math.abs(endY - startY);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", earliestStart=" + earliestStart +
                ", latestFinish=" + latestFinish +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ride)) return false;
        Ride ride = (Ride) o;
        return id == ride.id &&
                getStartX() == ride.getStartX() &&
                getStartY() == ride.getStartY() &&
                getEndX() == ride.getEndX() &&
                getEndY() == ride.getEndY() &&
                getEarliestStart() == ride.getEarliestStart() &&
                getLatestFinish() == ride.getLatestFinish();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getStartX(), getStartY(), getEndX(), getEndY(), getEarliestStart(), getLatestFinish());
    }
}
