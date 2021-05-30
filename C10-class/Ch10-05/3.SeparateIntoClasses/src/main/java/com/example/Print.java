package com.example;

public class Print {
    final int WW = 10;
    int PAGENUMBER = 1;
    int PAGEOFFSET = 1;
    int ROWOFFSET;
    int C;
    int RR;
    int CC;  
    int M;
    int[] P;

    public Print(int rR, int cC, int m, int[] p) {
        RR = rR;
        CC = cC;
        M = m;
        P = p;
    }

    public void print() {
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
    
}
