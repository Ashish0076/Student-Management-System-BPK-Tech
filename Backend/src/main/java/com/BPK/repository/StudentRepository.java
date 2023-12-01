package com.BPK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BPK.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
