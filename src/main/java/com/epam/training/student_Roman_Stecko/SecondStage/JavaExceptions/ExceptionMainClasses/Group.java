package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionMainClasses;

import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.GroupException;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.Faculty;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.GroupName;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.Subject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class Group {
    private Faculty faculty;
    private GroupName groupName;

    private List<Subject> listOfSubjects;
    private List <Student> listOfStudents;

    public Group(Faculty faculty, GroupName groupName, List<Subject> listOfSubjects, List<Student> listOfStudents) throws GroupException {
        this.faculty = faculty;
        this.groupName = groupName;
        this.listOfSubjects = listOfSubjects;
        this.listOfStudents = listOfStudents;
        if (listOfStudents.isEmpty()) {
            throw new GroupException("List of students is empty");
        }
        if (listOfSubjects.isEmpty()) {
            throw new GroupException("List of subjects is empty");
        }
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public List <Subject> getListOfSubjects() { return listOfSubjects; }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public Student getStudentFromGroupByID(String ID) throws GroupException {

        for (Student  students : listOfStudents){
            if (students instanceof Student && (students.getId().equals(ID))) {
                return students;
            }
        }
        throw new GroupException ("Can`t find this student in this group");
    }

    public double getAverageMarkOfGroupBySubject (Subject subject) throws GroupException {
        if (subject == null) {
            throw new GroupException ("Something wrong in input, null group");
        }
        double k = 0;
        double [] c = new double[listOfStudents.size()];
        for (int j = 0; j < listOfStudents.size(); j++) { //перебор студентов группы
            for (int q = 0; q < listOfSubjects.size(); q++) { //перебор предметов в группе каждого студента
                for (int i = 0; i < listOfStudents.get(0).getMarks().length; i++) { //перебор оценок каждого студента
                    if (q == i && listOfSubjects.get(q) == subject) {
                        c[j] = listOfStudents.get(j).getMark(i);
                    }
                }
            }
            k += c[j];
        }

        double result = k / (double) listOfStudents.size();
        BigDecimal resultFormat = new BigDecimal(result);
        return resultFormat.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return faculty == group.faculty && groupName == group.groupName && Objects.equals(listOfSubjects, group.listOfSubjects) && Objects.equals(listOfStudents, group.listOfStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, groupName, listOfSubjects, listOfStudents);
    }



    @Override
    public String toString() {
        return "\nGroup " + groupName +
                ", faculty=" + faculty +
                ", subjects = " + listOfSubjects +
                ", listOfStudents=" + listOfStudents +
                '}';
    }

}
