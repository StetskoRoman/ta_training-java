package com.epam.training.student_Roman_Stecko.SecondStage.JavaIO.OptTask2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PublicToPrivate {
    public static void main(String[] args) {
        System.out.println("Start program");
        String path = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/OptTask2/dataOpt2";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/ProgForOptTask2"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/ChangedOptTask2"))){
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("public");
                Matcher matcher = pattern.matcher(line);
                String output = matcher.replaceAll("private");
                bufferedWriter.write(output, 0, output.length());
                bufferedWriter.newLine();
            }
            System.out.println("Program end, all public words changed to private");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
