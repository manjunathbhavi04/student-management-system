package com.example.student_management_app.teachers;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TeacherRepository {
    HashMap<Integer, Teacher> teachersList = new HashMap<>();

    public TeacherRepository() {
        teachersList.put(1000, new Teacher(1000, "Kishore", 32, "kishore@gmamil.com"));
        teachersList.put(1001, new Teacher(1001, "Kamesh", 28, "kamesh@gmamil.com"));
        teachersList.put(1002, new Teacher(1002, "yadgiri", 42, "yadgiri@gmamil.com"));

    }

    public Teacher getTeacher(int id){
        return teachersList.get(id);
    }

    public HashMap<Integer, Teacher> getAllTeachers() {
        return teachersList;
    }

    public void setTeachersList(HashMap<Integer, Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public void addTeacher(int id, Teacher teacher){
        teachersList.put(id, teacher);
    }
}
