package com.epam.training.student_Roman_Stecko.SecondStage.JavaThreads.MainTask;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class RunnerParking {
    private static int nPlaces = 10;
    private volatile boolean freePlaceExist;
    private CopyOnWriteArrayList<ParkingPlace> places;
    private int oftenOfCar = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RunnerParking)) return false;
        RunnerParking that = (RunnerParking) o;
        return freePlaceExist == that.freePlaceExist && oftenOfCar == that.oftenOfCar && Objects.equals(places, that.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freePlaceExist, places, oftenOfCar);
    }


    public RunnerParking(int nPlaces, boolean freePlaceExist, CopyOnWriteArrayList<ParkingPlace> places) {
        this.nPlaces = nPlaces;
        this.freePlaceExist = freePlaceExist;
        this.places = places;
    }

    @Override
    public String toString() {
        return "RunnerParking{" +
                "freePlaceExist=" + freePlaceExist +
                ", places=" + places +
                ", oftenOfCar=" + oftenOfCar +
                '}';
    }

    public synchronized boolean isFreePlaceExist() {
        int sum = 0;
        for (ParkingPlace place : places) {
            if (place.isPlaceFree == false) {
                sum++;
            }
        }
        if (sum >= nPlaces) {
            freePlaceExist = false;
        } else {
            freePlaceExist = true;
        }

        return freePlaceExist;
    }

    public int getnPlaces() {
        return nPlaces;
    }


    public static void main(String[] args) {
        CopyOnWriteArrayList<ParkingPlace> parkingPlaces = new CopyOnWriteArrayList<>();
        for (int i = 0; i < nPlaces; i++) {
            parkingPlaces.add(new ParkingPlace(i, true));
        }
        RunnerParking runnerParking = new RunnerParking(nPlaces, true, parkingPlaces);
        System.out.println("There are " + runnerParking.getnPlaces() + "places on parking");

        for (int i = 0; i < 100; i++) {
            System.out.println("Step " + i);
            new Thread(new CarToPark(i, runnerParking, parkingPlaces)).start();

            try {
                TimeUnit.SECONDS.sleep(runnerParking.oftenOfCar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
