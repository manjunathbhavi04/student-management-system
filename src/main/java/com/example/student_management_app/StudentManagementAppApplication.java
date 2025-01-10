package com.example.student_management_app.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.student_management_app/students", "com/example/student_management_app/teachers"})
public class StudentManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementAppApplication.class, args);
	}

}
