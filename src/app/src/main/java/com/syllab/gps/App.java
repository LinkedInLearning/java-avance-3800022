package com.syllab.gps;

public class App {
    public static final int NORD  = 0;
    public static final int SUD   = 1;
    public static final int EST   = 2;
    public static final int OUEST = 3;

    public static void main(String[] args) {
        Object [][] bordeaux = {
            { 44.833328, NORD  },
            {   0.56667, OUEST }
        };
        
        for(var coord : bordeaux) {
            var decimal = (int)(3600.*(double)coord[0]);
            
            System.out.printf("%d°%d'%d\"", decimal/3600, (decimal/60)%60, decimal%60);
            System.out.println(coord[1]);
        }
        System.out.println();
    }

    public enum Direction {
        NORD ,
        SUD  ,
        EST  ,
        OUEST
    }
}
