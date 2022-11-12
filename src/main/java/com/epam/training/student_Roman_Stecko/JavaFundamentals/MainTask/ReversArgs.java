package com.epam.training.student_Roman_Stecko.JavaFundamentals.MainTask;

import java.util.Scanner;

public class ReversArgs {
    public static void main(String[] args) {

        System.out.println("input string for reverse");
        Scanner arguments = new Scanner(System.in);
        StringBuilder re = new StringBuilder(arguments.nextLine());
        re.reverse();
        System.out.println(re);
    }
}


