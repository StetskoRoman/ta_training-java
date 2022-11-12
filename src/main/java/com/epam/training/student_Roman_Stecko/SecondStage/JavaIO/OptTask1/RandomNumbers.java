package com.epam.training.student_Roman_Stecko.SecondStage.JavaIO.OptTask1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RandomNumbers implements Serializable{
    public static void main(String[] args) {
        String path = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/OptTask1/dataOpt1";
        System.out.println("Input amount of random elements: ");
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();
        System.out.println("Enter max(min) element in massive: ");
        int max = scanner.nextInt();
        int [] createRandomNumbers = new CreateRandomNumbers(nElements, max).makeRandom();

        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(path + "/randomNumbers.txt");
        File fileResult = new File(path + "/SortedRandomNumbers.txt");

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (int i = 0; i < createRandomNumbers.length; i++) {
                printWriter.print(createRandomNumbers[i] + " ");
            }
            printWriter.flush();
            System.out.println("File with random array of integer numbers was created ");
            System.out.println(Arrays.toString(createRandomNumbers));

        } catch (IOException e) {
            e.printStackTrace();
        }

        int [] newArray = new int[createRandomNumbers.length];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileResult)))){

            String line = bufferedReader.readLine();
            String[] integers = line.split(" ");
            for (int i = 0; i < createRandomNumbers.length; i++) {
                newArray[i] = Integer.parseInt(integers[i]);
            }
            System.out.println("Start sorting and create new file");

            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < createRandomNumbers.length - 1; i++) {
                    if (newArray[i] > newArray[i + 1]) {
                        int temp = newArray[i];
                        newArray[i] = newArray[i + 1];
                        newArray[i + 1] = temp;
                        sorted = false;
                    }
                }
            }
            for (int i = 0; i < newArray.length; i++) {
                printWriter.print(newArray[i] + " ");
                System.out.print(newArray[i] + " ");
            }
            System.out.println("\nTask completed, watch the results in dataOpt1");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
