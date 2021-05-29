package com.example;


public class PrintPrimes {
    final int M = 1000;
    int P[] = new int[M + 1];

    public PrintPrimes() {
    }

    public static void main(String[] args) {
            PrintPrimes p = new PrintPrimes();
            p.generate();
            p.print();
    }

    public void print() {
        final int RR = 50;
        final int CC = 4;
        final int WW = 10;
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        int C;

        while (PAGEOFFSET <= M) {
            System.out.println("The First " + M + " Prime Numbers --- Page " + PAGENUMBER);
            System.out.println("");
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++) {
                for (C = 0; C < CC; C++)
                    if (ROWOFFSET + C * RR <= M)
                        System.out.format("%10d", P[ROWOFFSET + C * RR]);
                System.out.println("");
            }
            System.out.println("\f");
            PAGENUMBER = PAGENUMBER + 1;
            PAGEOFFSET = PAGEOFFSET + RR * CC;
        }
    }

    public void generate() {
        int J = 1;
        int SQUARE = 9;
        int ORD = 2;
        int N;
        boolean JPRIME;
        final int ORDMAX = 30;
        int MULT[] = new int[ORDMAX + 1];
        int K = 1;
        P[1] = 2;
        while (K < M) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] = MULT[N] + P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N = N + 1;
                }
            } while (!JPRIME);
            K = K + 1;
            P[K] = J;
        }
    }
}