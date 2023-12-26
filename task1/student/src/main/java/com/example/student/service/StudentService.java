package com.example.student.service;

import java.util.List;

import com.example.student.model.Student;

public interface StudentService {
	public List<Student> studentDetails();
	
	Student save(Student student);
	
	void delete(long id);
	
	public Student edit(Student student);
	
	public Student addTeacherByIdAndTeacherId(long id, long teacherId);
}
