package com.syllab.premiers;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        var pool = ForkJoinPool.commonPool();
        var premiers = pool.invoke(new RecherchePremiers(1, 200_000));

        premiers.stream().limit(500).forEach(n -> System.out.printf("%d ", n));
        System.out.printf("%d nombres premiers trouvés\n", premiers.size());
    }
}
