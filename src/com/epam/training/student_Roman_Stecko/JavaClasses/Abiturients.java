package com.epam.training.student_Roman_Stecko.JavaClasses;

public class Abiturients {

    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String addres;
    private String phoneNumber;
    private int[] estimation;

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddres() {
        return addres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int[] getEstimation() {
        return estimation;
    }

    public void setEstimation(int[] estimation) {
        this.estimation = estimation;
    }

    public Abiturients(long id, String surname, String name, String patronymic, String addres, String phoneNumber, int[] estimation) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.addres = addres;
        this.phoneNumber = phoneNumber;
        this.estimation = estimation;
    }


    private String printArray (int[] estimation) {
        String numbers = "";
        for (int num: estimation){
            numbers += num + "  ";
        }
        return numbers;
    }

    public void printInfo(){
        System.out.println(id + ",  " + surname + " " + name + " " + patronymic + ":  " + addres + ",  " + phoneNumber + ". Estimations: " + printArray(estimation));
    }
    public double avg (int[] estimation){
        int result = 0;
        for (int num: estimation){
            result += num;
        }
        return (double)result/(double)estimation.length;
    }

}
