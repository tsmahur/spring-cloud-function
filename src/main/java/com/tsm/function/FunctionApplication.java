package com.tsm.function;

import com.tsm.function.entity.Student;
import com.tsm.function.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class FunctionApplication {

	@Autowired
	StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(FunctionApplication.class, args);
	}

	//creating beans for function ...no need of controller
	//but these can implemented in controller as well (similar API implemented in controller)

	@Bean  //GET
	public Supplier<List<Student>> getAllStudent(){
		return ()->studentService.getAllStudent();   //supplier - do not take input , send response
	}

	@Bean  //POST
	public Consumer<Student> saveStudent(){
		return stu->studentService.saveStudent(stu);   //consumer -take input not sending response
	}
	@Bean  //POST
	public Function<Integer,String> deleteStudentById(){
		return id->studentService.deleteStudentById(id);   //function - take input send response
	}

	@Bean  //POST
	public Function<Integer,Student> getStudentById(){
		return id->studentService.getStudentById(id);
	}

	@Bean  //POST
	public Function<List<Student>,String> getStudentAvgAge(){
		return stuList->studentService.getStudentAvgAge(stuList);
	}

//	@Bean  //POST  //how to pass id and body together - ??
//	public Consumer<Student> updateStudent(){
//		return (id,student)->studentService.updateStudent(id,student);
//	}

}
