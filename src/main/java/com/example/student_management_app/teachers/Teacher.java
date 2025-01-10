package com.example.student_management_app.teachers;

public class Teacher {
    private int t_id;
    private String name;
    private int age;
    private int no_of_students;
    private String email;

    public Teacher() {
    }

    public Teacher(int t_id, String name, int age, String email) {
        this.t_id = t_id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.no_of_students = 0;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo_of_students() {
        return no_of_students;
    }

    public void setNo_of_students(int no_of_students) {
        this.no_of_students = no_of_students;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
