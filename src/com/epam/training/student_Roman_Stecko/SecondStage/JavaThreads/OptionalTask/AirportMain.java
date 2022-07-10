package com.epam.training.student_Roman_Stecko.SecondStage.JavaThreads.OptionalTask;


public class AirportMain {
    private static int nPlanes = 10;
    public static void main(String[] args) {

        Resource resource = new Resource();
        for (int i = 1; i <= 5; i++) {
            new Thread (new Way(i, resource, nPlanes)).start();
        }
    }
}
