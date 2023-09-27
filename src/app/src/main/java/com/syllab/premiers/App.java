package com.syllab.premiers;

public class App {
    public static void main(String[] args) {
        var premiers = new RecherchePremiers(1, 200_000).trouver();

        premiers.stream().limit(500).forEach(n -> System.out.printf("%d ", n));
        System.out.printf("%d nombres premiers trouvés\n", premiers.size());
    }
}
