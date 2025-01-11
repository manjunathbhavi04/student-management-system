package com.example.student_management_app.students;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private final HashMap<Integer, Student> studList = new HashMap<>(); //data structure to store the data

    StudentRepository() {
        studList.put(1, new Student("Manjunath", 1, 22, "manjunathbhavi@gmail.com", "python"));
        studList.put(2, new Student("David", 2, 23, "davidpaul@gmail.com", "AI/ML"));
        studList.put(3, new Student("john", 3, 26, "johnpaul@gmail.com", "java"));
    }

    public HashMap<Integer, Student> getStudList() {
        return studList;
    }
    public List<String> getStudentNames(){
        List<String> names = new ArrayList<>();
        for(Student s: studList.values()){
            names.add(s.getName());
        }
        return names;
    }
    public void addStudent(int usn, Student stud){
        studList.put(usn, stud);
    }
}
