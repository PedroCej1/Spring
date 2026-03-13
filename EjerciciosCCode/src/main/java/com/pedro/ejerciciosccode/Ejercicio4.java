package com.pedro.ejerciciosccode;

public class Ejercicio4 {

    public void employeeMethod(Employee employee) {
        // Sacamos el salario mensual
        double monthlySalary = getMonthlySalary(employee.getYearlySalary(), employee.getAwards());
        //no tengo muy claro para que sirve este metodo pero le pongo un print para que haga algo
        System.out.println("Salario: "+ monthlySalary);
    }
    public double getMonthlySalary(double yearlySalary, double awards)
    {
        return (yearlySalary + awards)/12;
    }

    public class Employee {
        private double yearlySalary = 20000;
        private double awards = 5000;
        public double getYearlySalary() {
            return yearlySalary;
        }

        public double getAwards() {
            return awards;
        }
    }
}
