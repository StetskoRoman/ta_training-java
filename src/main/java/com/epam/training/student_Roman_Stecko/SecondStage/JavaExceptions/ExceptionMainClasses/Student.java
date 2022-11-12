package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionMainClasses;

import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.StudentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String id;
    private String name;
    //enum Subjects{MATH, PHYSICS, MECHANICS};
    private int[] marks;

    public Student(String id, String name, int[] marks) throws StudentException {
        this.id = id;
        this.name = name;
        this.marks = marks;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 10) {
                throw new StudentException("marks can be only from 0 to 10");
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int getMark (int n) {
        int a = 0;
        for (int i = 0; i < marks.length; i++) {
            if (n == i) {
                a = marks[n];
            }
        }
        return a;
    }

    public double averageMarkOfStudent () { //какой именно студент определяется в классе Group
        double sum = 0;
        double result = 1;
        for (int i = 0; i < marks.length; i++){
            sum += marks[i];
        }
        result = sum/marks.length;
        BigDecimal resultFormat = new BigDecimal(result);
        return resultFormat.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Arrays.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
    }

    @Override
    public String toString() {
        return "\nStudent {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
