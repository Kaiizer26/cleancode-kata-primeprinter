package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int numberOfPrimes = 1000;
    private final int[] primes = new int[numberOfPrimes + 1];
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];
    private int pagenumber = 1;
    private int pageoffset = 1;
    private int rowoffset;
    private int column;
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;

    public void print() {
        primes[1] = 2;

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

    private void printPrimes(int[] primes, int numberOfPrimes) {
    }
}


