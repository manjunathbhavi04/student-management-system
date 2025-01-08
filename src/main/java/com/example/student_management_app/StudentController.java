package com.example.student_management_app;
// This is a controller where we write the api for our class Student

import org.springframework.web.bind.annotation.*;

import java.util.*;

//Controller for endpoints
@RestController
@RequestMapping("/students") //initial mapping when our website opens example student.com/students is the initial endpoint for our api to work
// endpoint -> localhost:8080/students
public class StudentController {

    private final StudentService studService;

    public StudentController() {
        studService = new StudentService();
    }

    @GetMapping //this is a annotation, for post it is @PostMapping
    //endpoint -> localhost:8080/students
    public Map<Integer, Student> getAllStudents() {
        return studService.allStudent();
    }

    @GetMapping("/sayHello") //sayHello is a endpoint
    //endpoint -> localhost:8080/students/sayHello
    public String sayHell() {
        return "Hello from the students";
    }

    @GetMapping("/getStudent")
    //endpoint -> localhost:8080/students/getStudent?usn=1
    public Student getStudent(@RequestParam("id") int usn) {
        return studService.getStudent(usn);
    }

    // can be used when a user creates a account on our app
    @PostMapping("/add")
    //endpoint -> localhost:8080/students/add with the body for our url
    public String addStudent(@RequestBody Student student){
        studService.addStudent(student.getUsn(), student);
        return "Student Added Successfully";
    }

    @PostMapping("/added")
    // endpoint -> localhost:8080/students/added and give the body for your endpoint in the postman or frontend
    public void addStudents(@RequestBody Student stud){
        studService.addStudent(stud.getUsn(), stud);
    }
}
