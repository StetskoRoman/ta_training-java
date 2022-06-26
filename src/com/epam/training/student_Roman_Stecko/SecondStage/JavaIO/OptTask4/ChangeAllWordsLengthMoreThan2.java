package com.epam.training.student_Roman_Stecko.SecondStage.JavaIO.OptTask4;

import java.io.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeAllWordsLengthMoreThan2 {
    public static void main(String[] args) {
        System.out.println("Start program");

        String path = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/OptTask4/dataOpt4";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/Program.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/ChangedOptTask4"))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String result = Pattern.compile("\\pL{2,}")
                        .matcher(line)
                        .replaceAll(m -> m.group().toUpperCase(Locale.ROOT));
                bufferedWriter.write(result, 0, result.length());
                bufferedWriter.newLine();
            }
            System.out.println("For watching result open ChangedOptTask4");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
