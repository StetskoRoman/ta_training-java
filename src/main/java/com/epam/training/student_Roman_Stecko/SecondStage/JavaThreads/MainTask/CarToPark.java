package com.epam.training.student_Roman_Stecko.SecondStage.JavaThreads.MainTask;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CarToPark implements Runnable {
    private volatile long idCar;
    RunnerParking runnerParking;
    CopyOnWriteArrayList <ParkingPlace> parkingPlace;
    final static private int waitingTime = 3;


    public long getIdCar() {
        return idCar;
    }

    public CarToPark(long idCar, RunnerParking runnerParking, CopyOnWriteArrayList<ParkingPlace> parkingPlace) {
        this.idCar = idCar;
        this.runnerParking = runnerParking;
        this.parkingPlace = parkingPlace;
    }

    public static void carGoOutOfParking(CarToPark carToPark, ParkingPlace parkingPlace) {
        System.out.println("car - " + carToPark.getIdCar() + " go out from the place № " + parkingPlace.getIdPlace());
        parkingPlace.isPlaceFree = true;
    }

    public static void carGoOnParking(CarToPark carToPark, ParkingPlace parkingPlace) {
        System.out.println("car - " + carToPark.getIdCar() + " stand on the place № " + parkingPlace.getIdPlace());
        parkingPlace.isPlaceFree = false;
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(35000)); //время которое будет на парковке находиться, случайное
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void run() {
        CarToPark carToPark = new CarToPark(idCar, runnerParking, parkingPlace);
        int delay = 0;
        System.out.println("New car № " + idCar + " come. Is there free place here? " + runnerParking.isFreePlaceExist());
        do {

            if (runnerParking.isFreePlaceExist() == true) {
                for (int i = 0; i < runnerParking.getnPlaces(); i++) {
                    if (parkingPlace.get(i).isPlaceFree == true) {
                        CarToPark.carGoOnParking(carToPark, parkingPlace.get(i));
                        carGoOutOfParking(carToPark, parkingPlace.get(i));
                        Thread.currentThread().interrupt();
                        break;
                    }

                }


            } else {
                System.out.println("Car " + carToPark.idCar + " waiting for the parking");
                while (runnerParking.isFreePlaceExist() == false && delay < waitingTime) {

                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                        delay += 1;
                        if (delay == waitingTime) {
                            System.out.println("Car " + carToPark.idCar + " don`t want to wait more and leave");
                            Thread.currentThread().interrupt();
                        } else {
                            System.out.println("Car " + carToPark.idCar + " waiting more");
                        }

                    } catch (InterruptedException e) {
                        System.out.println("Car " + idCar + " leave, interrupted");
                    }
                }
            }
        } while ((delay <= waitingTime) && (Thread.currentThread().isInterrupted() == false) );

    }
}
