package com.syllab.gps;

public class App {
     public static void main(String[] args) {
        Object [][] bordeaux = {
            { 44.833328, Direction.NORD  },
            {   0.56667, Direction.OUEST }
        };
        assert(Direction.NORD.estCombinableAvec(Direction.OUEST));

        for(var coord : bordeaux) {
            var decimal = (int)(3600.*(double)coord[0]);
            
            System.out.printf("%d°%d'%d\"", decimal/3600, (decimal/60)%60, decimal%60);
            System.out.println(coord[1]);
        }
        System.out.println();
    }

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
}
