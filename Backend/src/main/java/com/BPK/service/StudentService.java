package com.BPK.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.BPK.model.Student;

@Service
public interface StudentService {

	    public Student addStudent(Student student);
	    public List<Student> getAllStudents();
	    public Student getStudentById(Integer studentId);
	    public Student updateStudent(Integer studentId, Student updatedStudent);
	    public void deleteStudent(Integer studentId);

}
