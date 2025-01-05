package com.example.student_management_app;

public class Student {
    private int usn; //primary key
    private String name;
    private int age;
    private String email;
    private String course;

    public Student() {
    }

    public Student(String name, int usn, int age, String email, String course) {
        this.name = name;
        this.usn = usn;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    //getters and setters
    public int getUsn() {
        return usn;
    }

    public void setUsn(int usn) {
        this.usn = usn;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
