package com.syllab.gps;

public class App {

     public static void main(String[] args) {
        var bordeaux = new Gps(44.833328, Direction.NORD, 0.56667, Direction.OUEST);

        assert(bordeaux.estValide());
        assert(Direction.NORD.estCombinableAvec(Direction.OUEST));

        System.out.println(bordeaux);

        var position = new Gps(44.833328, Direction.NORD, 0.56667, Direction.OUEST);

        if(position.equals(bordeaux)) {
            System.out.println("Même position");
        }
    }
}
