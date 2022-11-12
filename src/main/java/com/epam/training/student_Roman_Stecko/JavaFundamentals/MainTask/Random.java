package com.epam.training.student_Roman_Stecko.JavaFundamentals.MainTask;

import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        System.out.println("Enter a number of elements ");
        Scanner nNumbers = new Scanner(System.in);
        int n = nNumbers.nextInt();
        System.out.println(n + " random numbers from 0 to " + (n-1));

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * n);
            System.out.print(" " + array[i] + " ");
        }
        System.out.println(" ");
        System.out.println("and now with the transition to a new line ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
