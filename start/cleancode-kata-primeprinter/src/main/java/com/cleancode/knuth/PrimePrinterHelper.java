package com.cleancode.knuth;

public class PrimePrinterHelper {
    private final int numberOfPrimes = 1000; // Nombre total de nombres premiers à générer
    private final int[] primes = new int[numberOfPrimes + 1]; // Tableau pour stocker les nombres premiers
    private final int linesPerPage = 50; // Nombre de lignes par page
    private final int columns = 4; // Nombre de colonnes

    public void printNumbers() {
        generatePrimes(); // Appel à la méthode pour générer les nombres premiers
        printPrimes(primes, numberOfPrimes); // Appel à la méthode pour imprimer les nombres premiers
    }

    private void generatePrimes() {
        primes[1] = 2; // Le premier nombre premier est 2
        int primeIndex = 1; // Index pour suivre le nombre de premiers trouvés
        int candidate = 1; // Candidat pour le prochain nombre premier
        boolean possiblyPrime; // Indicateur pour savoir si le candidat est un nombre premier

        while (primeIndex < numberOfPrimes) {
            candidate += 2; // On ne considère que les nombres impairs
            possiblyPrime = true; // On suppose que le candidat est un nombre premier
            for (int n = 2; n <= primeIndex && possiblyPrime; n++) {
                if (candidate % primes[n] == 0) {
                    possiblyPrime = false; // Le candidat n'est pas premier
                }
            }
            if (possiblyPrime) {
                primeIndex++;
                primes[primeIndex] = candidate; // On ajoute le nombre premier trouvé au tableau
            }
        }
    }

    private void printPrimes(int[] numbers, int numberOfNumbers) {
        int pageNumber = 1; // Numéro de la page
        int pageOffset = 1; // Décalage de la page

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
            pageOffset += linesPerPage * columns; // Mise à jour du décalage de la page
        }
    }
}