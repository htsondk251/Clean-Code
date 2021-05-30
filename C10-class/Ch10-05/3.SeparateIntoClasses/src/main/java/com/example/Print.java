package com.example;

import java.io.PrintStream;

public class Print {
    int PAGEOFFSET = 1;
    int ROWOFFSET;
    int rowsPerPage;
    int columnsPerPage;
    int numbersPerPage;
    String pageHeader;
    PrintStream printStream;

    public Print(int rowsPerPage, int columnsPerPage, String pageHeader) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
        this.numbersPerPage = rowsPerPage * columnsPerPage;
        this.pageHeader = pageHeader;
        printStream = System.out;
    }

    public void print(int[] P) {
        int pageNumber = 1;
        for (int firstIndexOnPage = 0; firstIndexOnPage < P.length; firstIndexOnPage += numbersPerPage) {
            int lastIndexOnPage = Math.min(firstIndexOnPage + numbersPerPage - 1, P.length - 1);
            printPageHeader(pageHeader, pageNumber);
            printPage(firstIndexOnPage, lastIndexOnPage, P);
            pageNumber++;
        }
    }

    private void printPage(int firstIndexOnPage, int lastIndexOnPage, int[] P) {
        while (PAGEOFFSET <= lastIndexOnPage) {
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + rowsPerPage; ROWOFFSET++) {
                for (int C = 0; C < columnsPerPage; C++)
                    if (ROWOFFSET + C * rowsPerPage <= P.length - 1)
                        printStream.format("%10d", P[ROWOFFSET + C * rowsPerPage]);
                printStream.println("");
            }
            printStream.println("\f");
            PAGEOFFSET = PAGEOFFSET + rowsPerPage * columnsPerPage;
        }
    }

    private void printPageHeader(String pageHeader, int pageNumber) {
        printStream.println(pageHeader + " --- Page " + pageNumber);
        printStream.println("");
    }
}
