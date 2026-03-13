package com.pedro.ejerciciosccode;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] euromillones1 = generarNumeros(50);
        for (int k : euromillones1) {
            System.out.print(k + " ");
        }

        System.out.println();
        int[] euromillones2 = generarNumeros(12);
        for (int j : euromillones2) {
            System.out.print(j + " ");
        }
    }

    public static int[] generarNumeros(int max) {

        int[] numeros = new int[5];
        int cantidad = 0;

        // mientras la cantidad de numeros sea menor que 5
        while (cantidad < numeros.length) {
            // Generar el numero
            int num = (int) (Math.random() * max) + 1;
            boolean repetido = false;

            //Comprobar que no esta repetido
            for (int j = 0; j < cantidad; j++) {
                if (numeros[j] == num) {
                    repetido = true;
                    break;
                }
            }
            // Si no esta repetido se guarda
            if (!repetido) {
                numeros[cantidad] = num;
                cantidad++;
            }
        }

        return numeros;
    }

}
