package SRange;

public class Track {

    private int number;
    private int distance;
    private boolean beltPresent = false;
    private boolean blackPowderRdy = false;
    private boolean buckshotRdy = false;
    private boolean proneShootingRdy = false;

    public Track(int number,int distance){
        this.number = number;
        this.distance = distance;
    }

    //9. Konstruktory przeciążają konstruktor bazowy
    public Track(int number,int distance, boolean beltPresent){
        this.number = number;
        this.distance = distance;
        this.beltPresent = beltPresent;
    }
    public Track(int number,int distance, boolean beltPresent, boolean blackPowderRdy){
        this.number = number;
        this.distance = distance;
        this.beltPresent = beltPresent;
        this.blackPowderRdy = blackPowderRdy;
    }
    public Track(int number,int distance, boolean beltPresent, boolean blackPowderRdy, boolean buckshotRdy){
        this.number = number;
        this.distance = distance;
        this.beltPresent = beltPresent;
        this.blackPowderRdy = blackPowderRdy;
        this.buckshotRdy = buckshotRdy;
    }
    public Track(int number,int distance, boolean beltPresent, boolean blackPowderRdy, boolean buckshotRdy, boolean proneShootingRdy){
        this.number = number;
        this.distance = distance;
        this.beltPresent = beltPresent;
        this.blackPowderRdy = blackPowderRdy;
        this.buckshotRdy = buckshotRdy;
        this.proneShootingRdy = proneShootingRdy;
    }

    public void setBeltPresent(boolean beltPresent) {
        this.beltPresent = beltPresent;
    }
    public void setBlackPowderRdy(boolean blackPowderRdy) {
        this.blackPowderRdy = blackPowderRdy;
    }
    public void setBuckshotRdy(boolean buckshotRdy) {
        this.buckshotRdy = buckshotRdy;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public void setProneShootingRdy(boolean proneShootingRdy) {
        this.proneShootingRdy = proneShootingRdy;
    }

    public int getDistance() {
        return distance;
    }
    public boolean isBeltPresent() {
        return beltPresent;
    }
    public boolean isBlackPowderRdy() {
        return blackPowderRdy;
    }
    public boolean isBuckshotRdy() {
        return buckshotRdy;
    }
    public boolean isProneShootingRdy() {
        return proneShootingRdy;
    }
}
