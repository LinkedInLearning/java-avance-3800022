package com.syllab.gps;

public class Gps {
    private double lat;
    private Direction dirlat;
    private double lon;
    private Direction dirlon;
    
    public Gps(double lat, Direction dirlat, double lon, Direction dirlon) {
        this.lat    = lat;
        this.dirlat = dirlat;
        this.lon    = lon;
        this.dirlon = dirlon;
    }
    public double    lat()    { return this.lat; }
    public Direction dirlat() { return this.dirlat; }
    public double    lon()    { return this.lon; }
    public Direction dirlon() { return this.dirlon; }

    public boolean estValide() {
        return this.lat<= 90.0 && dirlat.estLatitude()
            && this.lon<=180.0 && dirlon.estLongitude();
    }
    public int deglat() { return (int)lat; }
    public int deglon() { return (int)lon; }

    public int minlat() { return (int)(lat*60)%60; }
    public int minlon() { return (int)(lon*60)%60; }
    
    public int seclat() { return (int)(lat*3600)%60; }
    public int seclon() { return (int)(lon*3600)%60; }
}
