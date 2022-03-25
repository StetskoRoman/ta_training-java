package com.epam.training.student_Roman_Stecko.JavaFundamentals.OptionalTask2;

import java.util.Scanner;

public class optTask2_4 {
   // Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
   public static void main(String[] args) {

       System.out.println("Enter array dimension ");
       Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       System.out.println("Random array " + n + " x " + n);
       System.out.println("Input Max value of a random number in the array");
       int maxValue = input.nextInt();
       System.out.println("Random numbers from " + -maxValue + " to " + maxValue);

       int[][] massive = new int[n][n];  //объявление двумерного массива
       for (int i = 0; i < massive.length; i++) {
           massive[i] = new int[n];
       }
       for (int i = 0; i < massive.length; i++) {
           for (int j = 0; j < massive.length; j++) {
               massive[i][j] = (int) (Math.random() * (maxValue - (-maxValue) + 2 ) - maxValue - 1);
           }
       }
       System.out.println("\nYour random array:");
       int max = 0;
       int imax = 0;
       int jmax = 0;
       for (int i = 0; i < massive.length; i++) {
           System.out.println("");
           for (int j = 0; j < massive.length; j++) {
               System.out.print("     " + massive[i][j]);
               if (massive[i][j] > max){
                   max = massive[i][j];
                   imax = i;
                   jmax = j;
               }
           }
       }
       System.out.println("\nMax number " + max + "    line " + (imax+1) + "     column " + (jmax+1));
       System.out.println("\nNow delete line and column with max number");

       for (int i = 0; i < massive.length; i++) {
           System.out.println("");
           for (int j = 0; j < massive.length; j++) {
           if (i == imax || j == jmax){
               String empty = "  ";

               System.out.print("     " + empty);
           }
           else {
               System.out.print("     " + massive[i][j]);
           }
           }
       }
   }
}

