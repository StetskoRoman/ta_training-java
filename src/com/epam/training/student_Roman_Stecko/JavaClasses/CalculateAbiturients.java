package com.epam.training.student_Roman_Stecko.JavaClasses;

import java.util.ArrayList;
import java.util.List;

public class CalculateAbiturients {

    public static void isNullOrEmpty (List<Abiturients> list) {
        if (list == null || list.isEmpty()) {
            throw new NullPointerException("list can`t be null or empty");
        }
    }

    public List<Abiturients> abitureentsWithBadMark (List<Abiturients> abiturients, int badMark) {
        isNullOrEmpty(abiturients);
        List <Abiturients> badAbiturients = new ArrayList<>();
        for (Abiturients ab : abiturients) {
            for (int num : ab.getEstimation()) {
                if (num < badMark) {
                    badAbiturients.add(ab);
                }
            }
        }
        return badAbiturients;
    }

    public List<Abiturients> abiturientsWithOnlyGoodMark (List <Abiturients> abiturients, int goodMark) {
        isNullOrEmpty(abiturients);
        List <Abiturients> goodAbiturients = new ArrayList<>();
        for (Abiturients ab : abiturients) {
            if (ab.averageMarks(ab.getEstimation()) > goodMark) {
                goodAbiturients.add(ab);
            }
        }
        return goodAbiturients;
    }

    public List <Abiturients> abiturientsWithAverageMark (List <Abiturients> abiturients) {
        isNullOrEmpty(abiturients);
        List <Abiturients> averageAbiturients = new ArrayList<>();
        for (int i = 0; i < abiturients.size() - 1; i++) {
            int tempi = i + 1;
            if (abiturients.get(i).averageMarks(abiturients.get(i).getEstimation()) < abiturients
                    .get(tempi).averageMarks(abiturients.get(tempi).getEstimation())) {
                averageAbiturients.add(abiturients.get(tempi));
            }
        }
        return averageAbiturients;
    }

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
        arrayAbiturients.add(new Abiturients(666, "Grechka", "Lidiya", "Viktorovna", "Minsk, pr-t Nezalejnosti, 155", "Phone 666-666",
                new int[]{5, 4, 4, 5}));

        System.out.println("List of students " + arrayAbiturients);

        int neudEstimate = 4;
        int goodEstimate = 7;

        CalculateAbiturients calculateAbiturients = new CalculateAbiturients();
        List <Abiturients> badAbiturients = calculateAbiturients.abitureentsWithBadMark(arrayAbiturients, neudEstimate);
        System.out.println("\nList of students, witch have estimates below than 4" + badAbiturients.toString());

        List <Abiturients> goodAbiturients = calculateAbiturients.abiturientsWithOnlyGoodMark(arrayAbiturients, goodEstimate);
        System.out.println("\nList of students, witch have average estimate 7 and higher" + goodAbiturients);

        List <Abiturients> averageAbiturients = calculateAbiturients.abiturientsWithAverageMark(arrayAbiturients);
        System.out.println("\nList of abiturients whose grades are above than average" + averageAbiturients);

    }
}
