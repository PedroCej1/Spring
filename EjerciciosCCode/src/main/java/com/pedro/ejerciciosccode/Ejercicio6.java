package com.pedro.ejerciciosccode;

import java.util.Scanner;

public class Ejercicio6 {

    static String[] colores = {"Azul", "Rojo", "Verde", "Amarillo"};

    public static void main(String[] args) {

        String[] solucion = generarSolucion();
        int intentosRestantes = 10;

        while (intentosRestantes > 0) {

            String[] intento = leerIntento();
            comprobarIntento(solucion, intento);

            if (ganado(solucion, intento)) {
                System.out.println("¡Has ganado!");
                return;
            }

            intentosRestantes--;
            System.out.println("Intentos restantes: " + intentosRestantes);
        }

        System.out.println("Has perdido. La solución era:");
        imprimirArray(solucion);
    }



    // Genera la combinacion
    public static String[] generarSolucion() {

        String[] solucion = new String[4];

        for (int i = 0; i < 4; i++) {
            int r = (int) (Math.random() * 4);
            solucion[i] = colores[r];
        }

        return solucion;
    }

    // Lee el intento del jugador
    public static String[] leerIntento() {

        Scanner sc = new Scanner(System.in);
        String[] intento = new String[4];

        System.out.println("Introduce 4 colores (Azul Rojo Verde Amarillo):");

        for (int i = 0; i < 4; i++) {
            intento[i] = sc.next();
        }

        return intento;
    }

    // Comprueba el intento
    public static void comprobarIntento(String[] solucion, String[] intento) {

        int blancas = 0;
        int negras = 0;

        boolean[] usadoSol = new boolean[4];
        boolean[] usadoInt = new boolean[4];

        // comprobar blancas
        for (int i = 0; i < 4; i++) {
            if (intento[i].equalsIgnoreCase(solucion[i])) {
                blancas++;
                usadoSol[i] = true;
                usadoInt[i] = true;
            }
        }

        // comprobar negras
        for (int i = 0; i < 4; i++) {

            if (!usadoInt[i]) {

                for (int j = 0; j < 4; j++) {

                    if (!usadoSol[j] && intento[i].equalsIgnoreCase(solucion[j])) {
                        negras++;
                        usadoSol[j] = true;
                        break;
                    }
                }

            }
        }

        System.out.println("Blancas: " + blancas);
        System.out.println("Negras: " + negras);
    }

    // Comprueba si ha ganado
    public static boolean ganado(String[] solucion, String[] intento) {

        for (int i = 0; i < 4; i++) {
            if (!intento[i].equalsIgnoreCase(solucion[i])) {
                return false;
            }
        }

        return true;
    }

    // Imprime un array
    public static void imprimirArray(String[] array) {

        for (String c : array) {
            System.out.print(c + " ");
        }

        System.out.println();
    }


}
