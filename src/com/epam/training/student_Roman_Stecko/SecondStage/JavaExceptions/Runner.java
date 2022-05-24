package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions;

import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.GroupException;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.StudentException;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.UniversityException;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.Faculty;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.GroupName;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.Subject;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionMainClasses.Group;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionMainClasses.Student;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionMainClasses.University;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws UniversityException, GroupException, StudentException {

        List<Student> groupEE_1 = new ArrayList<>(); //список студентов в группе
        groupEE_1.add (new Student("E1_1", "Artem", new int[] {4, 5, 6})); //E-факультет 1-первая группа _1-первый студент
        groupEE_1.add(new Student("E1_2", "Ann", new int[] {7, 5, 8}));

        List<Student> groupEE_2 = new ArrayList<>();
        groupEE_2.add(new Student("E2_1", "Ben", new  int[] {7, 10, 9}));
        groupEE_2.add(new Student("E2_2", "Barbara", new int[] {8, 10, 7}));

        List<Student> groupIE_1 = new ArrayList<>();
        groupIE_1.add(new Student("I1_1", "Dean", new int[] {10, 9, 9}));
        groupIE_1.add(new Student("I1_2", "Dana", new int[] {7, 8, 4}));

        List<Student> groupIE_2 = new ArrayList<>();
        groupIE_2.add(new Student("I2_1", "Eugen", new int[] {4, 5, 2}));
        groupIE_2.add(new Student("I2_2", "Elisabeth", new int[] {7, 8, 10}));

        List<Student> groupME_1 = new ArrayList<>();
        groupME_1.add(new Student("M1_1", "Greg", new int[] {5, 5, 6}));
        groupME_1.add(new Student("M1_2", "Gena", new int[] {4, 4, 4}));

        List<Student> groupME_2 = new ArrayList<>();
        groupME_2.add(new Student("M2_1", "Jack", new int[] {7, 8, 5}));
        groupME_2.add(new Student("M2_2", "Julia", new int[] {9, 9, 9}));
        groupME_2.add(new Student ("M2_3", "Jacob", new int[] {9, 2, 5}));

        List<Subject> EESubjects = new ArrayList<>(); //предметы для факультетов
        EESubjects.add(Subject.MATHEMATICS);
        EESubjects.add(Subject.PHYSICS);
        EESubjects.add(Subject.PHILOSOPHY);

        List<Subject> IESubjects = new ArrayList<>();
        IESubjects.add(Subject.PHILOSOPHY);
        IESubjects.add(Subject.MATHEMATICS);
        IESubjects.add(Subject.INFORMATICS);

        List<Subject> MESubjects = new ArrayList<>();
        MESubjects.add(Subject.PHYSICS);
        MESubjects.add(Subject.MECHANICS);
        MESubjects.add(Subject.PHILOSOPHY);

        List<Group> allGroupsInUniversity = new ArrayList<>(); //список групп в университете
        Group EE_1 = new Group(Faculty.ENERGY_ENGINEER, GroupName.EE_1, EESubjects, groupEE_1);
        Group EE_2 = new Group(Faculty.ENERGY_ENGINEER, GroupName.EE_2,  EESubjects, groupEE_2);
        Group IE_1 = new Group(Faculty.INFORMATION_ENGINEER, GroupName.IE_1, IESubjects, groupIE_1);
        Group IE_2 = new Group(Faculty.INFORMATION_ENGINEER, GroupName.IE_2, IESubjects, groupIE_2);
        Group ME_1 = new Group(Faculty.MECHANICAL_ENGINEER, GroupName.ME_1, MESubjects, groupME_1);
        Group ME_2 = new Group(Faculty.MECHANICAL_ENGINEER, GroupName.ME_2, MESubjects, groupME_2);
        allGroupsInUniversity.add(EE_1);
        allGroupsInUniversity.add(EE_2);
        allGroupsInUniversity.add(IE_1);
        allGroupsInUniversity.add(IE_2);
        allGroupsInUniversity.add(ME_1);
        allGroupsInUniversity.add(ME_2);

        University university = new University("BNTU", allGroupsInUniversity);
        System.out.println("\nBNTU university^" + allGroupsInUniversity);
        System.out.println("get the second student from group EE2" + EE_2.getStudentFromGroupByID("E2_2"));
        System.out.println("Average mark or this student is " + EE_2.getStudentFromGroupByID("E2_2").averageMarkOfStudent());

        System.out.println("Average mark of the subject in the group ME_2 by  " + Subject.MECHANICS + " = " + ME_2.getAverageMarkOfGroupBySubject(Subject.MECHANICS));
        System.out.println("Average mark at the university by " + Subject.PHILOSOPHY + " = " + university.getAverageMarkForSubjectByAllUniversity(Subject.PHILOSOPHY));

    }
}
