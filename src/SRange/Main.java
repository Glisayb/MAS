package SRange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track(1,25));
        Address address = new Address("Warsaw","Waldorffa","23");
        Range w23 = new Range(address,tracks);
        System.out.println(w23.numOfBelts());
        System.out.println(Range.getLongestDistance());
        System.out.println(w23.getAddress().toString());
    }
}