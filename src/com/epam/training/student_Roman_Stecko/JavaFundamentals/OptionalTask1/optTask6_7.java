package com.epam.training.student_Roman_Stecko.JavaFundamentals.OptionalTask1;

import java.util.Scanner;

public class optTask6_7 {
    public static void main(String[] args) {
        System.out.println("Enter n of numbers");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int numbers[] = new int[n];
        System.out.println("Now enter your numbers");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
            System.out.print(numbers[i] + " ");
        }
        increasingDigits(numbers);
        onlyDifferentDigits(numbers);
    }
    // the digits are different only(7)
    public static void onlyDifferentDigits(int[] array) {
        for (int value : array) {
            boolean isDistinct = true;
            char[] chars = String.valueOf(value).toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        isDistinct = false;
                        break;
                    }
                }
                if (!isDistinct) {
                    break;
                } else  if (i == chars.length - 2){
                    System.out.println("\nFirst number with only different digits  are " + value);
                    return;
                }
            }
        }
        System.out.println("\nThere are no numbers with different digits only");
    }

    //only increasing digits (6)
    public static void increasingDigits(int[] array) {
        for (int value : array){
            boolean raise = true;
            char [] chars = String.valueOf(value).toCharArray();

            for (int i = 0; i < array.length - 1; i++){
                for (int j = i+1; j < chars.length; j++){
                    if (chars[j] <= chars[i]){
                        raise = false;
                        break;
                    }
                }
                if (!raise) {
                    break;
                } else  if (i == chars.length - 2){
                    System.out.println("\n\nFirst number with only increasing digits are " + value);
                    return;
                }
            }

        }
        System.out.println("\nThere are no numbers with increasing digits only");
    }

}
