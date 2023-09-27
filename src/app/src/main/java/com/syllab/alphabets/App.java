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

    public static class Alice extends Thread {
        private int limite, delai;

        public Alice(int limite, int delai) {
            this.limite = limite;
            this.delai = delai;
        }
        @Override
        public void run() {
            alphabet("^-^", this.limite, this.delai);
        }
    }

    public static class Bob implements Runnable {
        private int limite, delai;

        public Bob(int limite, int delai) {
            this.limite = limite;
            this.delai = delai;
        }
        @Override
        public void run() {
            alphabet("°o°", this.limite, this.delai);
        }
    }

    public static void main(String[] args) {
        var thAlice = new Alice(18, 500);
        var thBob   = new Thread(new Bob(21, 300));
        var thCarol = new Thread(() -> alphabet("o_o", 20, 700));

        thAlice.start();
        thBob  .start();
        thCarol.start();
        try {
            thAlice.join();
            thBob  .join();
            thCarol.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace(System.err);
        }
    }
}
