package com.epam.training.student_Roman_Stecko.JavaCollections.JavaCollections_OptionalTasks;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class SortFromArrayList {
    //Opt task 6
    public static void main(String[] args) throws Exception {
        try {
            ArrayList<String> listPoem = new ArrayList<>(Files.readAllLines(Paths.get("poem.txt")));
            for (String poemLines : listPoem){
                System.out.println(poemLines);
            }
            Collections.sort(listPoem); // сортирует строки в алфавитном порядке
            System.out.println("");
            for (String poemLines : listPoem) {
                System.out.println(poemLines);
            }

        }
        catch (Exception e) {
            System.out.println("Exception, can`t continue.");
        }
    }
}
