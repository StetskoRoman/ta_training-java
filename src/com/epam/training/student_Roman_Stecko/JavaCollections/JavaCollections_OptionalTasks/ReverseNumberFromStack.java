package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_OptionalTasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;



public class ReverseNumberFromStack {
    //Opt task 2

    public static void main(String[] args) {

        System.out.println("Enter your integer number for reverse");
        Scanner scanner = new Scanner(System.in);
        int numberForReverse = scanner.nextInt();
        String number = Integer.toString(numberForReverse);

        Deque<Integer> stack = new ArrayDeque<>();
        int[] digitFromNumber = new int[number.length()];

        for (int i = 0; i < number.length(); i++)
        {
            digitFromNumber[i] = number.charAt(i) - '0';
            stack.push(digitFromNumber[i]);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
