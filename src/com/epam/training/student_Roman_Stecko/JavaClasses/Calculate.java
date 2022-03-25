package com.epam.training.student_Roman_Stecko.JavaClasses;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public static void main(String[] args) {

        List<Abiturients> arrayAbiturients = new ArrayList<>();

        arrayAbiturients.add(new Abiturients(111, "Sidorov", "Taras", "Ivanovich", "Minsk, Surganova 35/5", "Phone: 111-111",
                new int[]{4, 2, 4, 5}));
        arrayAbiturients.add(new Abiturients(222, "Petrov", "Marat", "Petrovich", "Minsk, Surganova 35/7", "Phone: 222-222",
                new int[]{4, 6, 5, 7}));
        arrayAbiturients.add(new Abiturients(333, "Tarasevich", "Gennadiy", "Tihonovich", "Minsk, Kolasa 19", "Phone: 333-333",
                new int[]{6, 9, 7, 9}));
        arrayAbiturients.add(new Abiturients(444, "Bur", "Olga", "Tihonovna", "Minsk, Kolasa 57", "Phone: 444-444",
                new int[]{2, 5, 4, 7}));
        arrayAbiturients.add(new Abiturients(555, "Kravec", "Mariya", "Fedorovna", "Minsk, Kolasa 55/2", "Phone: 555-555",
                new int[]{7, 8, 9, 9}));

        System.out.println("list of abiturients");
        for (Abiturients ab : arrayAbiturients)
            ab.printInfo();

        System.out.println("\nList of abiturients with unsatisfactory estimations");
        int neudEstimate = 4;
        for (Abiturients ab : arrayAbiturients) {
            for (int num : ab.getEstimation()) {
                if (num < neudEstimate) {
                    ab.printInfo();
                }
            }
        }

        int zadannoe = 7;
        System.out.println("\nList of abiturients with average grades above the set " + zadannoe);
        for (Abiturients ab : arrayAbiturients) {
            if (ab.avg(ab.getEstimation()) > zadannoe) {
                ab.printInfo();
            }
        }

        System.out.println("\nList of abiturients whose grades are above than average ");
        for (int i = 0; i < arrayAbiturients.size() - 1; i++) {
            int tempi = i + 1;
            if (arrayAbiturients.get(i).avg(arrayAbiturients.get(i).getEstimation()) < arrayAbiturients
                    .get(tempi).avg(arrayAbiturients.get(tempi).getEstimation())) {
                Abiturients maxAb = arrayAbiturients.get(tempi);
                maxAb.printInfo();

            }
        }
    }
}
