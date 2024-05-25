package SRange;

import java.awt.*;
import java.util.*;

public class Range {
    static private ArrayList<Range> ranges = new ArrayList<>();
    static private int totalNumOfTracks = 0;

    private ArrayList<Person> staff; //1 Zwykła
    private ArrayList<Gun> rentalGunsList; //2 Z atrybutem
    private ArrayList<Track> tracks; //4 Kompozycja

    private Address address;
    private OptionalDouble avgDistance;
    private int maxDistance;
    private Optional<Point> geoLocal;
    public Range(Address address, int maxDistance, int slots){
        this.address = address;
        this.maxDistance = maxDistance;
        this.tracks = new ArrayList<>();
        this.rentalGunsList = new ArrayList<>();
        this.staff = new ArrayList<>();
        totalNumOfTracks += slots;
        addTracks(slots);
        ranges.add(this);

    }

    int numOfBelts(){
        return (int) tracks.stream().filter(track -> track.isBeltPresent()==true).count();
    }


    static int getLongestDistance(){
        int maxDistance = 0;
        for (Range range: ranges) {
            var tracks = range.getTracks();
            for (Track track:tracks){
                int distance = track.getDistance();
                maxDistance = (maxDistance > distance) ? maxDistance : distance;
            }
        }
        return maxDistance;
    }

    //4 Kompozycja
    public void addTracks(int amount){
        int size = tracks.isEmpty()?0:tracks.size();
        for (int i = 1; i<= amount; i++) {
            this.tracks.add(Track.addTrack(this.address,size+i,maxDistance));
        }
        calcAvgDistance();
    }
    public void removeLastTrack(){
        if (getTrack(tracks.size()).isPresent()) {
            Track.removeTrack(getTrack(tracks.size()-1).get());
            tracks.remove(tracks.size()-1);
        }
    }

    public void calcAvgDistance(){
        this.avgDistance = tracks.stream()
                .mapToDouble(Track::getDistance)
                .average();
    }

    public String getGeoLocal() {
        if (geoLocal!=null){
            System.out.println("wspolrzedna Xowa: "+geoLocal.get().getX());
            System.out.println("wspolrzedna Yowa: "+geoLocal.get().getY());
            return  geoLocal.get().getX()+" "+geoLocal.get().getY();
        }
        else{
            System.out.println("nie wprowadzono jeszcze wspolrzednych");
            return "PUSTE";
        }
    }

    public boolean addStaff(Person person) {
        if (staff.stream().anyMatch(s -> s.getPesel() == person.getPesel())) {
            System.out.println("nie no, on już tu pracunje");
            return false;
        }
        else{
            staff.add(person);
            return true;
        }
    }

    public void removeGun(String gunIDnumber){
        this.rentalGunsList.remove(Gun.getGuns(gunIDnumber));
        Gun.destroyGun(gunIDnumber);
    }
    public void addGun(String gunIDnumber){
        Gun.changeOwner(gunIDnumber,this);
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

    void printGeoLocal(){
        if (geoLocal!=null){
            System.out.println("wspolrzedna Xowa: "+geoLocal.get().getX());
            System.out.println("wspolrzedna Yowa: "+geoLocal.get().getY());
        }
        else{
            System.out.println("nie przowadzono jeszcze wspolrzednych");
        }
    }
}
