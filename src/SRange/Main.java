package SRange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ArrayList<Track> tracks = new ArrayList<>();
        Address address1 = new Address("Warsaw","Waldorffa","23");
        Address address2 = new Address("Suchodol","Suchodolska","1");
        Range w23 = new Range(address1,25,5);

        System.out.println(w23.numOfBelts());
        w23.setTrackDistance(2,13);
        w23.printGeoLocal();
        w23.setGeoLocal(21,37);
        w23.printGeoLocal();

        System.out.println(Range.getLongestDistance());
        System.out.println(w23.getAddress().toString());
        System.out.println(w23.getAvgDistance());

        Range s1 = new Range(address1,300,2);

        System.out.println(Range.getLongestDistance());

    }
}