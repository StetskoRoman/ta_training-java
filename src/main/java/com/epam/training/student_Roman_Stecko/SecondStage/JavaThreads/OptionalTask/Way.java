package com.epam.training.student_Roman_Stecko.SecondStage.JavaThreads.OptionalTask;


import static java.lang.Thread.currentThread;


public class Way implements Runnable {
    private int idWay;
    Resource plane;
    private int maxPlaneQueue;

    public Way(int idWay, Resource plane, int maxPlaneQueue) {
        this.idWay = idWay;
        this.plane = plane;
        this.maxPlaneQueue = maxPlaneQueue;
    }

    public synchronized int getIdWay() {
        return idWay;
    }

    public static synchronized void getPlaneToWay(int idWay, Resource plane) {
        plane.nPlanes++;


    }

    @Override
    public synchronized void run() {

        while (!currentThread().isInterrupted()) {
            Way.getPlaneToWay(idWay, plane);
            int pl = plane.nPlanes;

            try {
                System.out.println("Airstrip " + idWay + " get a plane № " + pl);
                Thread.sleep(100);
                System.out.println("Plane № " + pl + " come to airstrip " + idWay);

                Thread.sleep(2900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Plane № " + pl + " fly up from the airstrip № " + idWay);
            System.out.println("airstrip № " + idWay + " is free");
            if (plane.nPlanes == maxPlaneQueue) {
                System.out.println("Airstrip " + idWay + " have no planes more, his work done");
                currentThread().interrupt();
            }
        }

    }
}

class Resource {
    volatile int nPlanes = 0;

}
