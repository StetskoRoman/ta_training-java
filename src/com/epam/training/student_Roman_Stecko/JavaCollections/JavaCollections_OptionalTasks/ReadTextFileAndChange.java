package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_OptionalTasks;

import java.io.*;
import java.util.*;


class ReadTextFileAndChange {

    //Opt tasks 1
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("poem.txt"));
        Stack<String> stringsPoem = new Stack<>();
        while (scanner.hasNextLine()) {
            stringsPoem.push(scanner.nextLine());
        }
        scanner.close();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("poemReverse.txt")))
        {

            while (!stringsPoem.empty()) {
                bufferedWriter.write(stringsPoem.peek() + "\n");
                bufferedWriter.flush();
                System.out.println(stringsPoem.pop());

            }
        }
        catch (Exception e){
            System.out.println("Java can`t deal with your task");
        }
    }
}
