package com.example.student_management_app;
// This is a controller where we write the api for our class Student

import org.springframework.web.bind.annotation.*;

import java.util.*;

//Controller for endpoints
@RestController
@RequestMapping("/students") //initial mapping when our website opens example student.com/students is the initial endpoint for our api to work
// endpoint -> localhost:8080/students
public class StudentController {

    Map<Integer, Student> stud = new HashMap<>(); //data structure to store the data

    public StudentController() {
        stud.put(1, new Student("Manjunath", 1, 22, "manjunathbhavi@gmail.com", "python"));
        stud.put(2, new Student("David", 2, 23, "davidpaul@gmail.com", "AI/ML"));
        stud.put(3, new Student("john", 3, 26, "johnpaul@gmail.com", "java"));
    }

    @GetMapping //this is a annotation, for post it is @PostMapping
    //endpoint -> localhost:8080/students
    public Map<Integer, Student> getAllStudents() {
        return stud;
    }

    @GetMapping("/sayHello") //sayHello is a endpoint
    //endpoint -> localhost:8080/students/sayHello
    public String sayHell() {
        return "Hello from the students";
    }

    @GetMapping("/getStudent")
    //endpoint -> localhost:8080/students?usn=1
    public Student getStudent(@RequestParam("id") int usn) {
        return stud.get(usn);
    }

    // can be used when a user creates a account on our app
    @PostMapping("/add")
    //endpoint -> localhost:8080/
    public String addStudent(@RequestBody Student student){
        stud.put(student.getUsn(), student);
        return "Student Added Successfully";
    }
}
