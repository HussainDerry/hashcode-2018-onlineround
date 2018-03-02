package iq.junit.hashcode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class HelperMethods {

    public static int getDistance(int startX, int startY, int endX, int endY){
        return Math.abs(endX - startX) + Math.abs(endY - startY);
    }

    public static Ride getNextRide(Car car, List<Ride> rides){
        int min = Integer.MAX_VALUE;
        Ride mRide = rides.get(0);
        for(int i = 0; i < rides.size(); i++) {
            int val = car.getRideValue(rides.get(i));
            if(val < min){
                mRide = rides.get(i);
                min = val;
            }
        }

        return mRide;
    }

    public static Car doRide(Car car, Ride ride){
        int val = car.getRideValue(ride);
        Counter.T += val;
        car.setCurrentX(ride.getEndX());
        car.setCurrentY(ride.getEndY());

        return car;
    }

}
