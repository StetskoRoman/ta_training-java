package com.epam.training.student_Roman_Stecko.JavaFundamentals.MainTask;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        System.out.println("Input your name, user! ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        System.out.println("Hello " + userName);
    }
}



