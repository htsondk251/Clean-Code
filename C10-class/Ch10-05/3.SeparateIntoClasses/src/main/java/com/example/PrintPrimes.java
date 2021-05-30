package com.example;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class PrintPrimes {
    int M;
    int P[];
    int RR;
    int CC;

    public PrintPrimes(int m, int rR, int cC) {
        M = m;
        RR = rR;
        CC = cC;
        P = new int[M + 1];
    }

    public static void main(String[] args) {
            PrintPrimes p = new PrintPrimes(1000, 20, 6);
            Generator generator = new Generator(p.M, p.P);
            generator.generate();
            Print printer = new Print(p.RR, p.CC, p.M, p.P);
            printer.print();
    }
}