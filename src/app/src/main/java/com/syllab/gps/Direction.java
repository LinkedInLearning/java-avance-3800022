package com.syllab.gps;

public enum Direction {
    NORD ('N', true),
    SUD  ('S', true),
    EST  ('E', false),
    OUEST('O', false);
    
    private char abrev;
    private boolean latitude;

    private Direction(char abrev, boolean latitude) {
        this.abrev = abrev;
        this.latitude = latitude;
    }
    public boolean estLatitude () { return this.latitude; }
    public boolean estLongitude() { return !this.latitude; }
    public boolean estCombinableAvec(Direction autre) { return this.latitude!=autre.latitude; }

    @Override
    public String toString() {
        return String.format("%c", abrev);
    }
}
