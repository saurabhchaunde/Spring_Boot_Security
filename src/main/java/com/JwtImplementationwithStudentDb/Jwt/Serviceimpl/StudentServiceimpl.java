package com.JwtImplementationwithStudentDb.Jwt.Serviceimpl;

import com.JwtImplementationwithStudentDb.Jwt.DaoRepository.StudentRepository;
import com.JwtImplementationwithStudentDb.Jwt.Model.Student;
import com.JwtImplementationwithStudentDb.Jwt.Service.StudentServiceinf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceimpl implements StudentServiceinf {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }

    public Optional<Student> getbyId(Integer id){

        return studentRepository.findById(id);
    }

    public Student AddStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student updateStudent(Student student,Integer id){
        student.setId(id);
        studentRepository.save(student);
        return student;
    }
    public void deletebyid(Integer id){
        studentRepository.deleteById(id);
    }


}
