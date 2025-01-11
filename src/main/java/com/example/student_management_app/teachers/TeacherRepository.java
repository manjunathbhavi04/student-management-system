package com.example.student_management_app.teachers;

import com.example.student_management_app.students.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TeacherRepository {
    HashMap<Integer, Teacher> teachersList = new HashMap<>();
    HashMap<Integer, List<Integer>> teacherStudentList = new HashMap<>(); //Integer is teacherId and List is students Id
    StudentRepository studRep;

    public TeacherRepository(){

    }

    @Autowired
    public TeacherRepository(StudentRepository studRep) {
        this.studRep = studRep;
        teachersList.put(1000, new Teacher(1000, "Kishore", 32, "kishore@gmamil.com"));
        teachersList.put(1001, new Teacher(1001, "Kamesh", 28, "kamesh@gmamil.com"));
        teachersList.put(1002, new Teacher(1002, "yadgiri", 42, "yadgiri@gmamil.com"));

    }

    public HashMap<Integer, Teacher> getAllTeachers() {
        return teachersList;
    }

    public Teacher getTeacher(int id){
        return teachersList.get(id);
    }

    public Teacher getTeacherWithName(String name){
        for(Teacher t : teachersList.values()){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }

    public List<String> getStudentList(int teacherId){
        List<String> list = new ArrayList<>();
        if(!teacherStudentList.containsKey(teacherId)) return list;
        for(int stud: teacherStudentList.get(teacherId)){
            list.add(studRep.getStudList().get(stud).getName());
        }
        return list;
    }

    public String deleteTeacher(String name){
        boolean found = false;
        for(Teacher t: teachersList.values()){
            if(t.getName().equals(name)){
                found = true;
                teachersList.remove(t.getT_id());
            }
        }
        return (found)?"found":"not found";
    }

    public String pairStudentTeacher(int studentId, int teacherId){

        //check if teacher id adn student id are present or not
        if(!teachersList.containsKey(teacherId) || !studRep.getStudList().containsKey(studentId)){
            return "Cannot be paired data not found";
        }

        if(!teacherStudentList.containsKey(teacherId)){
            teacherStudentList.put(teacherId, new ArrayList<>());
        }
        teacherStudentList.get(teacherId).add(studentId);
        teachersList.get(teacherId).setNo_of_students();
        return "Paired Successfully";
    }

    public void setTeachersList(HashMap<Integer, Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public void addTeacher(int id, Teacher teacher){
        teachersList.put(id, teacher);
    }
}
