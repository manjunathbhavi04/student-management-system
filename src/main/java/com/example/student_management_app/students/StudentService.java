package com.example.student_management_app.students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student getStudent(int usn) {
        return studentRepo.getStudList().get(usn); // get(usn) is the HashMap function don't try to find it in the code here
    }

    public HashMap<Integer, Student> allStudent() {
        return studentRepo.getStudList();
    }

    public String addStudent(int usn, Student stud) {
        studentRepo.addStudent(usn, stud);
        return "Student Added Successfully";
    }
}
