package com.epam.training.student_Roman_Stecko.JavaFundamentals.OptionalTask1;

import java.util.Scanner;


public class optTask1_2 {
    public static void main(String[] args) {
        System.out.println("Enter n of numbers");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]numbers = new int[n];
        System.out.println("Now enter your numbers");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
            System.out.print(numbers[i] + " ");
        }
        printMin(numbers);
        printMax(numbers);
        increasing(numbers);

    }
    //min (1)
        public static void printMin(int[] array){
            int min = array[0];
            int minnumber = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    minnumber = i;
                }
            }
            int lengthNumber = (String.valueOf(min)).length();

        System.out.println("\nMinimal number is " + min + ", it`s " + (minnumber + 1) + " in a raw, ");
        System.out.println("Minimal number length is " + lengthNumber);
    }
    //max (1)
    public static void printMax(int[] array){
        int max = array[0];
        int maxnumber = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
                maxnumber = i;
            }
        }
        int lengthNumber = (String.valueOf(max)).length();
        System.out.println("\nMaximal number is " + max + ", it`s " + (maxnumber + 1) + " in a raw");
        System.out.println("Maximal number length is " + lengthNumber);
    }
    // from min to max (2)
    public static void increasing(int[] array) {
            boolean sorted = false;
            while (!sorted){
                sorted = true;
                for (int i = 0; i < array.length - 1; i++){
                    if (array[i]>array[i+1]){
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                    }
                }
            }
            System.out.println("\nnow in ascending order");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }

}








