package SRange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ArrayList<Track> tracks = new ArrayList<>();
        Address address = new Address("Warsaw","Waldorffa","23");
        Range w23 = new Range(address,25,5);
        System.out.println(w23.numOfBelts());


        System.out.println(Range.getLongestDistance());
        System.out.println(w23.getAddress().toString());
        System.out.println(w23.getAvgDistance());
    }
}