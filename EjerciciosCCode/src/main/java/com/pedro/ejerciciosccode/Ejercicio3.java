package com.pedro.ejerciciosccode;

public class Ejercicio3 {
    public Ejercicio3() {
    }

    public void calcQuadraticEq(double a, double b, double c) {
       // la formula es x = [ -b +- raiz de (b^2-4ac) ] / 2a
        double parentesis = b * b - (4 * a * c);
        if (parentesis > 0) {
            //Calcula el resultado positivo y el negativo
            double result1 = (-b - Math.sqrt(parentesis)) / (2 * a);
            double result2 = (-b + Math.sqrt(parentesis)) / (2 * a);
            System.out.println("result1 = " + result1 + ", result2 = " + result2);
        }
        else if (parentesis == 0) System.out.println("x = " + (-b / (2 * a)));
        else System.out.println("Equation has no roots");
    }
}


