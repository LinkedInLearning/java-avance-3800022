package com.syllab.gps;

public record Gps(double lat, Direction dirlat, double lon, Direction dirlon) {

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

    @Override
    public String toString() {
        return String.format(
            "%d°%d'%d\"%s, %d°%d'%d\"%s", 
            deglat(), minlat(), seclat(), this.dirlat,
            deglon(), minlon(), seclon(), this.dirlon
        );
    }
}
