package com.example.student_management_app.teachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
    public Teacher getTeachByName(String name){
        return teachRepo.getTeacherWithName(name);
    }
    public List<String> getStudentList(int teacherId){
        return teachRepo.getStudentList(teacherId);
    }
    public String pairStudentTeacher(int studentId, int teacherId){
        return teachRepo.pairStudentTeacher(studentId, teacherId);
    }
    public String deleteTeacher(String name){
        return teachRepo.deleteTeacher(name);

    }
    public String addTeacher(int id, Teacher teacher){
        teachRepo.addTeacher(id, teacher);
        return "Added Successfully";
    }
}
