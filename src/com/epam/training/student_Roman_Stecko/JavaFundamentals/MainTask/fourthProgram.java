package com.epam.training.student_Roman_Stecko.JavaFundamentals.MainTask;

import java.util.Scanner;

public class fourthProgram {
    public static void main(String[] args) {
        System.out.println("Enter a number of elements in massive ");
        Scanner nElements = new Scanner(System.in);
        int n = nElements.nextInt();
        int a;
        int sum = 0;
        int multi = 1;
        System.out.println("Enter massive");
        Scanner enterMassive = new Scanner(System.in);
        for (int i = 0; i< n; i++) {
            a = enterMassive.nextInt();
            sum = sum + a;
            multi = multi * a;

        }
        System.out.println("sum = " + sum);
        System.out.println("multiplication = " + multi);


    }

}
