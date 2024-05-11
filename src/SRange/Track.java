package SRange;

public class Track {

    private int number;
    private int distance;
    private Address address;
    private boolean beltPresent = false;
    private boolean blackPowderRdy = false;
    private boolean buckshotRdy = false;
    private boolean proneShootingRdy = false;

    public Track(Address address, int number,int distance){
        this.number = number;
        this.distance = distance;
        this.address = address;
    }

    public Track(Address address, int number,int distance, boolean beltPresent, boolean blackPowderRdy, boolean buckshotRdy, boolean proneShootingRdy){
        this.number = number;
        this.distance = distance;
        this.address = address;
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

    public int getNumber() {        return number;    }

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
