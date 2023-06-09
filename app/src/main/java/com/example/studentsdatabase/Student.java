package com.example.studentsdatabase;

public class Student {
    private int id;
    private String name;
    private String last_name;
    private String patronymic;
    private String date;
    private String group;

    public Student(int id, String name, String last_name, String surname, String date, String group) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.patronymic = surname;
        this.date = date;
        this.group = group;
    }

    public Student(String name, String last_name, String surname, String date, String group) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = surname;
        this.date = date;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String surname) {
        this.patronymic = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
