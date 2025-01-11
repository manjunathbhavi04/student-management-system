package com.example.student_management_app.teachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    TeacherService teachService;

    @Autowired
    public TeacherController(TeacherService teachService){
        this.teachService = teachService;
    }

    @GetMapping
    // endpoint -> localhost:8080/teachers
    public ResponseEntity<HashMap<Integer, Teacher>> getAllTeachers(){
        HashMap<Integer, Teacher> teachers = teachService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/getTeacher")
    // endpoint -> localhost:8080/teachers/getTeacher?id=1000
    public ResponseEntity<Teacher> getTeacher(@RequestParam("id") int id){
        Teacher teacher = teachService.getTeacher(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/getTeacherByName")
    public ResponseEntity<Teacher> getTeachByName(@RequestParam("name") String name){
        Teacher t = teachService.getTeachByName(name);
        return new ResponseEntity<>(t, HttpStatus.FOUND);
    }

    @GetMapping("/studentList/{id}")
    public ResponseEntity<List<String>> studentList(@PathVariable("id") int teacherId){
        List<String> list = teachService.getStudentList(teacherId);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/stud/{id}")
    public String studd(@PathVariable("id") int teacherId){
//        List<String> list = teachService.getStudentList(teacherId);
        return "Wroking";
    }

    @PutMapping("/student-teacher-pair")
    public ResponseEntity<String> pairStudentTeacher(@RequestParam int studentId, @RequestParam int teacherId){
        String message = teachService.pairStudentTeacher(studentId, teacherId);
        if(!message.equals("Paired Successfully")) return new ResponseEntity<>("Cannot be paired data not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeacher(@RequestParam String name){
        String message = teachService.deleteTeacher(name);
        if(!message.equals("found")) return new ResponseEntity<>("Teacher Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/addTeacher")
    // endpoint -> localhost:8080/teachers/addTeacher with body
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        String Message = teachService.addTeacher(teacher.getT_id(), teacher);
        return new ResponseEntity<>(Message, HttpStatus.CREATED);
    }
}
