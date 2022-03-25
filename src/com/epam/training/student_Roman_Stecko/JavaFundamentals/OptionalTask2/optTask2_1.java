package com.epam.training.student_Roman_Stecko.JavaFundamentals.OptionalTask2;

import java.util.Scanner;

public class optTask2_1 {
    //Упорядочивание столбца матрицы в порядке возрастания значений элементов k-й строки
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
        for (int i = 0; i < massive.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < massive.length; j++) {
                System.out.print("     " + massive[i][j]);
            }
        }

        System.out.println("\nNow enter number of line you want arrange in ascending order (1-t line is 0)");
        int line = input.nextInt();
        if (line >= n){
            System.out.println("\n number of line must be from 0 to " + (n - 1));
        }

        for (int i = 0; i < massive.length; i++) {
            if (i == line) {
                    boolean sorted = false;
                    while (!sorted) {
                        sorted = true;
                        for (int j = 0; j < massive.length - 1; j++) {
                            if (massive[i][j] > massive[i][j + 1]) {
                                int temp = massive[i][j];
                                massive[i][j] = massive[i][j + 1];
                                massive[i][j + 1] = temp;
                                sorted = false;
                            }
                        }
                    }
            }
        }
        for (int i = 0; i < massive.length; i++) {
            System.out.println("");
            for (int j = 0; j < massive.length; j++) {
                System.out.print("     " + massive[i][j]);

            }
        }
    }

}
