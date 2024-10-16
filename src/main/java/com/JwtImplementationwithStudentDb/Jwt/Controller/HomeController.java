package com.JwtImplementationwithStudentDb.Jwt.Controller;


import com.JwtImplementationwithStudentDb.Jwt.Model.Student;
import com.JwtImplementationwithStudentDb.Jwt.Service.StudentServiceinf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class HomeController {

    @Autowired
    private StudentServiceinf studentServiceinf;

    @RequestMapping("/home")
    public String home(){
        return "Hey Saurabh!";
    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudnt(){
    List<Student> list=studentServiceinf.getAllStudent();
    return ResponseEntity.of(Optional.of(list));
    }
//    @GetMapping("/student/{id}") public ResponseEntity<Student> getStudenbyid(@PathVariable("id") int id) {
//        Optional<Student> optionalStudent = Optional.ofNullable(studentServiceinf.getbyId(id));
//
//        if (optionalStudent.isPresent()) {
//            return ResponseEntity.ok(optionalStudent.get());
//        } else {
//            throw new RuntimeException("Students not found");
//        }
//    }
@GetMapping("student/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {

        Optional<Student> s = studentServiceinf.getbyId(id);
         return ResponseEntity.ok(s.get());
}


    @PostMapping("/student")
    public void AddStudent(@RequestBody Student student){
        Student savedStudent = studentServiceinf.AddStudent(student);
        ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/student/{id}")
    public void Deletestudent(@PathVariable("id") int id){
        this.studentServiceinf.deletebyid(id);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        Optional<Student> savedStudent = Optional.ofNullable(studentServiceinf.updateStudent(student, id));

        return ResponseEntity.ok(savedStudent.get());
    }

}
