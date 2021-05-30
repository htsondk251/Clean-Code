package com.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Generator {
    int M;
    int[] P;
    
    public Generator(int m, int[] p) {
        M = m;
        P = p;
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
