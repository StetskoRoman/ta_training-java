package com.epam.training.student_Roman_Stecko.SecondStage.JavaThreads.MainTask;

public class ParkingPlace {
    private int idPlace;
    volatile boolean isPlaceFree;

    public ParkingPlace(int idPlace, boolean isPlaceFree) {
        this.idPlace = idPlace;
        this.isPlaceFree = isPlaceFree;
    }


    public int getIdPlace() {
        return idPlace;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "idPlace=" + idPlace +
                ", isPlaceFree=" + isPlaceFree +
                '}';
    }

}
