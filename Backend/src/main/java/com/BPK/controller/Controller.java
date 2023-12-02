package com.BPK.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BPK.model.Student;
import com.BPK.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://student-management-system-bpk-tech.netlify.app")
@RestController
public class Controller {

    @Autowired
    private StudentService studentService;

    // Endpoint to add a new student
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all students
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Endpoint to retrieve a specific student by ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        Student student = studentService.getStudentById(studentId);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update an existing student
    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(studentId, updatedStudent);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to remove a student
    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

