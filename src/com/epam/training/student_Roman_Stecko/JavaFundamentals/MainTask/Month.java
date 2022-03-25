package com.epam.training.student_Roman_Stecko.JavaFundamentals.MainTask;

import java.util.Scanner;

public class Month {
    public static void main(String[] args) {
        System.out.println("Enter № of month ");
        Scanner scan = new Scanner(System.in);
        int nMonth = scan.nextInt();
        System.out.println(choiceMonth(nMonth));
    }
    public static String choiceMonth(int n){
        String[] month = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
        if(n > 0 && n<month.length) return month[n];
        else return "Month not found, enter month from 1 to 12";
    }
}
