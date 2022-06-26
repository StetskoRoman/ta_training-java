package com.epam.training.student_Roman_Stecko.SecondStage.JavaIO.OptTask7;

import java.io.*;


public class RemoveWordsSince3To5Literals {
    public static void main(String[] args) {
        System.out.println("Start program");
        String path = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/OptTask7/dataOpt7";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/Berezi"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/ChangedBerezi"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String newString = getClearString(line);
                bufferedWriter.write(newString, 0, newString.length());
                bufferedWriter.newLine();
            }
            System.out.println("For watching result open ChangedBerezi");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //3-5 символов в слове - удалить в каждой строке максимальное четное количество таких слов
    public static String getClearString (String string) {
        int n = 0;
        int temp = 0;
        String tempString = null;
        String [] line = string.split("\\s|,|!|\\.");
        for (int i = 0; i < line.length; i++){
            if ((line[i].length() >= 3) && (line[i].length() <= 5)) {
                tempString = line[i];
                line[i] = "";
                n++;
                temp = i;
            }
        }
        if (n % 2 == 1) {
            line[temp] = tempString;
        }
        String result = "";
        for (int i = 0; i < line.length; i++) {
            result += line[i] + " ";

        }
        return result;
    }
}
