package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/get")
//	@GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Student> getData() {
		return studentService.studentDetails();
	}
	
	@DeleteMapping("/delete")
	public List<Student> deleteData(@RequestParam("id") long id) {
		studentService.delete(id);
		return studentService.studentDetails();
	}
	
	@PostMapping("/add")
	public Student addData(@RequestBody Student student){
		return studentService.save(student);
	}
	
	@PutMapping("/edit")
	public Student editData(@RequestBody Student student)
	{
		return studentService.edit(student);
	}
	
	@PutMapping("/addTeacher")
	public Student addTeacherById(@RequestParam("studentId") long id,@RequestParam("teacherId") long teacherId){
		return studentService.addTeacherByIdAndTeacherId(id, teacherId);
	}
}
