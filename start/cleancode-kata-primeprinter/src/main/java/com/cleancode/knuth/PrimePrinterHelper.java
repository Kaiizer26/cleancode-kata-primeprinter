package com.cleancode.knuth;

public class PrimePrinterHelper {
    private final int numberOfPrimes = 1000;
    private final int[] primes = new int[numberOfPrimes + 1];
    private final int linesPerPage = 50;
    private final int columns = 4;

    public void printNumbers() {
        generatePrimes();
        printPrimes(primes, numberOfPrimes);
    }

    private void generatePrimes() {
        primes[1] = 2;
        int primeIndex = 1;
        int candidate = 1;
        boolean possiblyPrime;

        while (primeIndex < numberOfPrimes) {
            candidate += 2;
            possiblyPrime = true;
            for (int n = 2; n <= primeIndex && possiblyPrime; n++) {
                if (candidate % primes[n] == 0) {
                    possiblyPrime = false;
                }
            }
            if (possiblyPrime) {
                primeIndex++;
                primes[primeIndex] = candidate;
            }
        }
    }

    private void printPrimes(int[] numbers, int numberOfNumbers) {
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= numberOfNumbers) {
            System.out.println("The First " + numberOfNumbers + " Prime Numbers === Page " + pageNumber);
            for (int rowOffset = pageOffset; rowOffset < pageOffset + linesPerPage && rowOffset <= numberOfNumbers; rowOffset++) {
                for (int column = 0; column < columns; column++) {
                    if (rowOffset + column * linesPerPage <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[rowOffset + column * linesPerPage]);
                    }
                }
                System.out.println();
            }
            System.out.println();
            pageNumber++;
            pageOffset += linesPerPage * columns;
        }
    }
}