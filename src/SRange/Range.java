package SRange;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;

public class Range {
    static private ArrayList<Range> Ranges = new ArrayList<>(); //1. Ekstensja klasy Range
    static private int totalNumOfTracks = 0; //5. Atrybut klasowy

    private Address address; //2. Atrybut złożony
    private ArrayList<Track> tracks; //4. Atrybut powtarzalny
    private OptionalDouble avgDistance; //6. Atrybut pochodny
    private int maxDistance;
    private Optional<Point> geoLocal; //3. Atrybut opcjonalny
    public Range(Address address, int maxDistance, int slots){
        this.address = address;
        this.maxDistance = maxDistance;
        this.tracks = new ArrayList<>();
        totalNumOfTracks += slots;
        addTracks(slots);
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


    public void addTracks(int amount){
        int size = tracks.isEmpty()?0:tracks.size();
        for (int i = 1; i<= amount; i++) {
            this.tracks.add(new Track(this.address,size+i,maxDistance));
        }
        calcAvgDistance();
    }

    public void calcAvgDistance(){
        this.avgDistance = tracks.stream()
                .mapToDouble(Track::getDistance)
                .average();
    }

    public Optional<Point> getGeoLocal() {
        return geoLocal;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public OptionalDouble getAvgDistance() {
        calcAvgDistance();
        return avgDistance;
    }

    public Optional<Track> getTrack(int trackNum){
        var track = getTracks().stream().filter(t -> t.getNumber() == trackNum ).findFirst();
        if (track.isPresent()) {
            return track;
        }
        else {
            throw new ArrayStoreException("nie ma takego toru na tej szczelnicy");
        }
    }
    public void setTrackDistance(int trackNum, int newDistance){
        getTrack(trackNum).get().setDistance(newDistance);
        calcAvgDistance();
    }

    public void setGeoLocal(double x, double y) {
        Point point = new Point();
        point.setLocation(x,y);
        this.geoLocal = Optional.of(point);
    }
}
