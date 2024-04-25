package SRange;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;


public class Range {
    static private ArrayList<Range> Ranges = new ArrayList<>(); //1. Ekstensja klasy Range
    static private int totalNumOfTracks; //5. Atrybut klasowy

    private Address address; //2. Atrybut złożony
    private ArrayList<Track> tracks; //4. Atrybut powtarzalny
    private int slots; //6. Atrybut pochodny
    private Optional<Point> geoLocal; //3. Atrybut opcjonalny
    public Range(Address address, ArrayList<Track> tracks){
        this.address = address;
        this.tracks = tracks;
        this.slots = tracks.size();
        totalNumOfTracks+=slots;
        Ranges.add(this);
    }

    int numOfBelts(){
        return (int) tracks.stream().filter(track -> track.isBeltPresent()==true).count();
    }

    //7. tu mamy metode klasowa
    static int getLongestDistance(){
        int maxDistance = 0;
        for (Range range:Ranges) {
            var tracks = range.getTracks();
            for (Track track:tracks){
                int distance = track.getDistance();
                maxDistance = (maxDistance > distance) ? maxDistance : distance;
            }
        }
        return maxDistance;
    }

    boolean hasGeoLocal(){
        return geoLocal.isPresent();
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
