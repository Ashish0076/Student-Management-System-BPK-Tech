package com.BPK.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BPK.model.Student;
import com.BPK.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Method to add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Method to retrieve all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Method to retrieve a specific student by ID
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    // Method to update an existing student
    public Student updateStudent(Integer studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);

        if (existingStudent != null) {
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setPhoneNo(updatedStudent.getPhoneNo());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setAddress(updatedStudent.getAddress());
            existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    // Method to delete a student
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
