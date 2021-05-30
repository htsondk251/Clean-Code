package com.example;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class PrintPrimes {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 1000;
        int[] P = Generator.generate(NUMBER_OF_PRIMES);
        final int ROWS_PER_PAGE = 20;
        final int COLUMNS_PER_PAGE = 6;

        Print printer = new Print(ROWS_PER_PAGE, COLUMNS_PER_PAGE, "The First " + NUMBER_OF_PRIMES + " Prime Numbers");
        printer.print(P);
    }
}