package com.pedro.ejerciciosccode;

public class Ejercicio2 {

    public class Address {
        private String country;
        private String city;
        private String street;
        private String house;
        private String quarter;

        public String getFullAddress() {
            return country + ", " + city  + ", " + street + ", " + house + " " + quarter;
        }
    }
    public class Human {

        private String name;
        private int age;
        private Address address;

        public String getFullAddress() {
            return address.getFullAddress();
        }

        // getters y setters
    }


}
