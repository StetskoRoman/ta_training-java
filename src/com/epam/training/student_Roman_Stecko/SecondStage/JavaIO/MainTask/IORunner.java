package com.epam.training.student_Roman_Stecko.SecondStage.JavaIO.MainTask;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IORunner {

    public static void main(String[] args) {

        String mainPathFiles = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/MainTask/DataForMainIO";
        String resultPathFile = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/MainTask/resultFile.txt";

        if (!Files.exists(Path.of(resultPathFile))) {
            try {
                Files.createFile(Path.of(resultPathFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File test = new File(mainPathFiles);
        File testWithFile = new File(resultPathFile);
        mainWorkMethod(test);
        System.out.println("File with tree created");
        mainWorkMethod(testWithFile);

    }

    public static void mainWorkMethod(File pathToDirectory) {
        if (pathToDirectory == null) {
            throw new UnsupportedOperationException("path does not exist");
        }
        String resultPathFile = "src/com/epam/training/student_Roman_Stecko/SecondStage/JavaIO/MainTask/resultFile.txt";
        if (pathToDirectory.isDirectory()) {
            try (PrintWriter printWriter = new PrintWriter(resultPathFile)){

                Files.walkFileTree(Paths.get(String.valueOf(pathToDirectory)), new SimpleFileVisitor<>() {
                    public FileVisitResult preVisitDirectory (Path path, BasicFileAttributes attributes)  {

                        if (path.equals(Paths.get(String.valueOf(pathToDirectory)))) {
                            return FileVisitResult.CONTINUE;
                        }

                        printWriter.println("|| " + path.getFileName());
                        List<File> album = Arrays.stream(path.toFile().listFiles()).toList(); //самая важная строка
                        for (int i = 0; i < album.size(); i++) {
                            File r = album.get(i);
                            printWriter.println("-- " + (i + 1) + " - " + r.getName());
                        }
                        printWriter.println();
                        printWriter.flush();
                        return FileVisitResult.CONTINUE;
                    }

                    public FileVisitResult postVisitDirectory (Path dir, IOException exc) {

                        return FileVisitResult.CONTINUE;
                    }
                    public FileVisitResult visitFileFailed (Path path, IOException exc)  {
                        return FileVisitResult.SKIP_SUBTREE;
                    }

                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (pathToDirectory.isFile()) {
            int nFiles = 0;
            int nDirectory = 0;
            double averageFilesInDirectory = 0;
            double averageFileNameSize = 0;
            int nLiterals = 0;

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resultPathFile))){
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    Pattern patternDirectory = Pattern.compile("\\|\\|");
                    Matcher matcherDirectory = patternDirectory.matcher(line);
                    while (matcherDirectory.find()){
                        nDirectory++;
                    }
                    Pattern patternFiles = Pattern.compile("--");
                    Matcher matcherFiles = patternFiles.matcher(line);
                    while (matcherFiles.find()) {
                        nFiles++;
                        nLiterals += line.length();

                    }
                    averageFilesInDirectory = (double) nFiles/nDirectory;
                    averageFileNameSize = (double) nLiterals/nFiles;

                }
                System.out.println("Amount of directories = " + nDirectory);
                System.out.println("Amount of files = " + nFiles);
                System.out.printf("Average files in directory = " + "%.3f\n", averageFilesInDirectory);
                System.out.printf("Average length of fileName = " + "%.3f", averageFileNameSize);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
