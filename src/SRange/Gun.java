package SRange;

import java.util.ArrayList;

public class Gun extends GunModel {

    static private ArrayList<Gun> guns = new ArrayList<>();

    private String gunIDnumber;
    private Object gunOwner;

    public Gun(String name, String gunIDnumber, Object gunOwner) {
        super(name);
        this.gunIDnumber = gunIDnumber;
        this.gunOwner = gunOwner;
        guns.add(this);
    }
    public static void destroyGun(String gunIDnumber){
        guns.remove(getGuns(gunIDnumber));
    }
    public static void changeOwner(String gunIDnumber,Object newOwner){
        getGuns(gunIDnumber).gunOwner=newOwner;
    }

    public static Gun getGuns(String gunIDnumber) {
        for (Gun gun:guns) {
            if (gun.gunIDnumber==gunIDnumber){
                return gun;
            }
        }
        return null;
    }
}
