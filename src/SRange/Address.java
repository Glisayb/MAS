package SRange;

public class Address {
    public String city;
    public String street;
    public String number;

    public Address(String city, String street, String number){
        this.city = city;
        this.street = street;
        this.number = number;
    }
    //8. Tu mamy przesloniecie
    @Override
    public String toString() {
        return ("ul. "+street+" "+number.toString()+", "+city);
    }
}
