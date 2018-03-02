package iq.junit.hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    List<Ride> rides = new ArrayList<>();

    public Parser(String filename, String outputFile) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String head = reader.readLine();
        System.out.println("Head: " + head);

        String[] headVals = head.split(" ");
        System.out.println(Arrays.toString(headVals));

        int maxT = Integer.parseInt(headVals[5]);
        System.out.println(maxT);
        int numOfCars = Integer.parseInt(headVals[2]);

        String nLine;
        int i = 0;
        while((nLine = reader.readLine()) != null) {
            String[] arr = nLine.split(" ");
            rides.add(new Ride(i, toInt(arr[0]), toInt(arr[1]), toInt(arr[2]), toInt(arr[3]), toInt(arr[4]), toInt(arr[5])));
            i++;
        }

        rides.forEach(ride->{
            System.out.println(ride);
        });

        reader.close();


        System.out.println("\n\n");

        StringBuilder mRides;
        BufferedWriter mWriter = new BufferedWriter(new FileWriter(outputFile));
        int count;
        try{
            for(int j = 1; j <= numOfCars; j++){
                Counter.T = 0;
                Car mCar = new Car(j);
                mRides = new StringBuilder();
                count = 0;
                while(Counter.T < maxT){
                    if(!rides.isEmpty()){
                        Ride next = HelperMethods.getNextRide(mCar, rides);
                        if(Counter.T + mCar.getRideValue(next) > maxT){
                            break;
                        }

                        mCar = HelperMethods.doRide(mCar, next);
                        mRides.append(next.getId()).append(" ");
                        rides.remove(next);
                        count++;
                    }else{
                        break;
                    }
                }
                System.out.println(String.format("%d %s", count, mRides.toString()));
                mWriter.append(String.format("%d %s", count, mRides.toString()));
                mWriter.append("\n");
            }
        }finally {
            mWriter.flush();
            mWriter.close();
        }
    }

    public int toInt(String value){
        return Integer.parseInt(value);
    }

    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        new Parser("./files/a.in", "./output/a.txt");
        new Parser("./files/b.in", "./output/b.txt");
        new Parser("./files/c.in", "./output/c.txt");
        new Parser("./files/d.in", "./output/d.txt");
        new Parser("./files/e.in", "./output/e.txt");
        System.out.println(String.format("Completed In %d ms", System.currentTimeMillis() - startTime));
    }


}
