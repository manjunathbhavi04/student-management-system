package com.example.student_management_app;


import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService() {
        studentRepo = new StudentRepository();
    }

    public Student getStudent(int usn) {
        return studentRepo.getStudList().get(usn);
    }

    public HashMap<Integer, Student> allStudent() {
        return studentRepo.getStudList();
    }

    public void addStudent(int usn, Student stud) {
        studentRepo.addStudent(usn, stud);
    }
}
