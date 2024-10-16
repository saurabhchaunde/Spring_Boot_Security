package com.JwtImplementationwithStudentDb.Jwt.DaoRepository;

import com.JwtImplementationwithStudentDb.Jwt.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
