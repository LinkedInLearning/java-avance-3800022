package com.syllab.alphabets;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class App {
    public static char alphabet(String emoticone, int limite, int delai) throws InterruptedException {
        for(var i=0; i<limite; i++) {
            System.out.printf("(%s) %c  ", emoticone, 'a'+i);
            Thread.sleep(delai);
        }
        System.out.printf(" (%s).\n", emoticone);
        return (char)('a' + limite);
    }

    public static void main(String[] args) {
        var pool = Executors.newFixedThreadPool(3);

        var f1 = pool.submit(() -> alphabet("^-^", 18, 500));
        var f2 = pool.submit(() -> alphabet("°o°", 21, 300));
        var f3 = pool.submit(() -> alphabet("o_o", 20, 700));
        var f4 = pool.submit(() -> alphabet("°!°", 15, 1000));

        try {
            System.out.printf("#1: <%c\n", f1.get());
            System.out.printf("#2: <%c\n", f2.get());
            System.out.printf("#3: <%c\n", f3.get());
            System.out.printf("#4: <%c\n", f4.get());
        }
        catch(ExecutionException e) {
            e.getCause().printStackTrace(System.err);    
        }
        catch(InterruptedException e) {
            e.printStackTrace(System.err);
        }

        pool.shutdown();
    }
}
