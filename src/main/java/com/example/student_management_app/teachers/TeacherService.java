package com.example.student_management_app.teachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TeacherService {

    TeacherRepository teachRepo;

    @Autowired
    public TeacherService(TeacherRepository teachRepo){
        this.teachRepo = teachRepo;
    }
    public HashMap<Integer, Teacher> getAllTeachers(){
        return teachRepo.getAllTeachers();
    }
    public Teacher getTeacher(int id){
        return teachRepo.getTeacher(id);
    }
    public String addTeacher(int id, Teacher teacher){
        teachRepo.addTeacher(id, teacher);
        return "Added Successfully";
    }
}
