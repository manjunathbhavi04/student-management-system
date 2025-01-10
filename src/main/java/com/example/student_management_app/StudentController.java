package com.example.student_management_app;
// This is a controller where we write the api for our class Student

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//Controller for endpoints
@RestController // RestController indirectly is defined by the Annotation @Component so the object for StudentController will be created by the Spring Framework
@RequestMapping("/students") //initial mapping when our website opens example student.com/students is the initial endpoint for our api to work
// endpoint -> localhost:8080/students
public class StudentController {

    private final StudentService studService;

    @Autowired
    public StudentController(StudentService studService) {
        this.studService =  studService;
    }

    @GetMapping //this is a annotation, for post it is @PostMapping
    //endpoint -> localhost:8080/students
    public ResponseEntity getAllStudents() {
        Map<Integer, Student> students = studService.allStudent();
        return new ResponseEntity(students, HttpStatus.OK);
    }

    @GetMapping("/sayHello") //sayHello is a endpoint
    //endpoint -> localhost:8080/students/sayHello
    public String sayHell() {
        return "Hello from the students";
    }

    @GetMapping("/getStudent")
    //endpoint -> localhost:8080/students/getStudent?usn=1
    public ResponseEntity getStudent(@RequestParam("id") int usn) {
        Student stud = studService.getStudent(usn);
        return new ResponseEntity(stud, HttpStatus.OK);
    }

    // can be used when a user creates a account on our app
    @PostMapping("/add")
    //endpoint -> localhost:8080/students/add with the body for our url
    public ResponseEntity addStudent(@RequestBody Student student){
        String message = studService.addStudent(student.getUsn(), student);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    @PostMapping("/added")
    // endpoint -> localhost:8080/students/added and give the body for your endpoint in the postman or frontend
    public ResponseEntity addStudents(@RequestBody Student stud){
        String message = studService.addStudent(stud.getUsn(), stud);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }
}
