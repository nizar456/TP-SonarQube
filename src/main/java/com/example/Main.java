package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }

        duplicateCode();
        duplicateCode();
    }

    public static void duplicateCode() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}