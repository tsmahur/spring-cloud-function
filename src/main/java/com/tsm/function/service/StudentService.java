package com.tsm.function.service;

import com.tsm.function.entity.Student;
import com.tsm.function.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student student) { //take input not sending response
        studentRepository.save(student);
    }
    public void updateStudent(Integer id, Student student) { //take input not sending response
        Optional<Student> optional = studentRepository.findById(id);
        Student scoreFound = optional.orElseThrow(() -> new RuntimeException("Student Not found"));
        scoreFound.setAge(student.getAge()); //get student and update
        scoreFound.setName(student.getName());
        studentRepository.save(scoreFound);
    }

    public Student getStudentById(Integer id) {//take input send response
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not fond"));
    }
    public List<Student> getAllStudent() {//do not take input send response
        return studentRepository.findAll();
    }
    public String deleteStudentById(Integer id) {//take input send response
        studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not fond"));
        studentRepository.deleteById(id);
        return "Deleted student : "+id;
    }

    public String getStudentAvgAge(List<Student> stuList) {//will be use for function pipelining
        Integer totalAge=0;
        for (Student student : stuList) {
            totalAge+=student.getAge();
        }
        int avg=totalAge/stuList.size();
        return "Avg age is : "+avg;
    }
}
