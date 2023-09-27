package com.syllab.alphabets;

public class App {
    public static void alphabet(String emoticone, int limite, int delai) {
        try {
            for(var i=0; i<limite; i++) {
                System.out.printf("(%s) %c  ", emoticone, 'a'+i);
                Thread.sleep(delai);
            }
            System.out.printf(" (%s).\n", emoticone);
        }
        catch(InterruptedException e) {
            System.err.printf("(%s)!\n", emoticone);
        }
    }

    public static void main(String[] args) {
        alphabet("^-^", 18, 500);
        alphabet("°o°", 21, 300);
        alphabet("o_o", 20, 700);
    }
}
