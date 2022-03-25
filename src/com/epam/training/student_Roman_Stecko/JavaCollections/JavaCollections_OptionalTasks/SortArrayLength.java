package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_OptionalTasks;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class SortArrayLength {

    public static void main(String[] args)  throws Exception {
        try {
            ArrayList<String> listPoem = new ArrayList<>(Files.readAllLines(Paths.get("poem.txt")));
            for (String poemLines : listPoem) {
                System.out.println(poemLines);
            }
            System.out.println("\n");

            listPoem.sort(((o1, o2) -> o1.length() - o2.length()));  //сортирует по количеству букв в строке, игнорируя пробелы и знаки препинания
            for (String poemLinesCompare : listPoem) {
                System.out.println(poemLinesCompare);
            }

        }
        catch (Exception e){
                System.out.println("Exception, can`t continue.");
            }

    }
}
