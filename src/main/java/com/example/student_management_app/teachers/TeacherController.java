package com.example.student_management_app.teachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    TeacherService teachService;

    @Autowired
    public TeacherController(TeacherService teachService){
        this.teachService = teachService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Integer, Teacher>> getAllTeachers(){
        HashMap<Integer, Teacher> teachers = teachService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/getTeacher")
    public ResponseEntity<Teacher> getTeacher(@RequestParam("id") int id){
        Teacher teacher = teachService.getTeacher(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/addTeacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        String Message = teachService.addTeacher(teacher.getT_id(), teacher);
        return new ResponseEntity<>(Message, HttpStatus.CREATED);
    }
}
