package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionMainClasses;

import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.GroupException;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass.UniversityException;
import com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionEnums.Subject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University { // надо или нет extends Group {
    private String UniversityName;
    private List <Group> allGroups;

    public University(String universityName, List<Group> allGroups) throws UniversityException {
        UniversityName = universityName;
        this.allGroups = allGroups;
        if (allGroups.isEmpty()) {
            throw new UniversityException("There are no groups at the university");
        }
        for (int i = 0; i < allGroups.size(); i++) {
            if (allGroups.get(i) == null) {
                throw new UniversityException("Group can`t be without faculty");
            }
        }

    }

    public String getUniversityName() {
        return UniversityName;
    }

    public List<Group> getAllGroups() {
        return allGroups;
    }

    public double getAverageMarkForSubjectByAllUniversity (Subject subject) throws GroupException {
        double sum = 0;
        int valueOfGroups = 0;
        for (Group group : allGroups) {
                sum += group.getAverageMarkOfGroupBySubject(subject);
                if (group.getListOfSubjects().contains(subject)){
                    valueOfGroups++;
                }
        }
        double result = sum/valueOfGroups;
        BigDecimal resultFormat = new BigDecimal(result);
        return resultFormat.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return Objects.equals(UniversityName, that.UniversityName) && Objects.equals(allGroups, that.allGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UniversityName, allGroups);
    }

    public Group getGroup(Group group) throws UniversityException {
        if (group == null){
            throw new UniversityException ("Null group, exception");
        }
        for (Group groups : allGroups){
            if (groups instanceof Group && (groups.getGroupName().equals(group.getGroupName()))) {
                return groups;
            }
        }
        throw new UniversityException("Can`t find this group");
    }

    @Override
    public String toString() {
        return "\nUniversity: " +
                  UniversityName;
    }
}
