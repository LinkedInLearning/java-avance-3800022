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
        var th1 = new Thread(() -> alphabet("^-^", 18, 500));
        var th2 = new Thread(() -> alphabet("°o°", 21, 300));
        var th3 = new Thread(() -> alphabet("o_o", 20, 700));
        var th4 = new Thread(() -> alphabet("°!°", 15, 1000));

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace(System.err);
        }
    }
}
