package com.example.teacher.service;

import java.util.List;

import com.example.teacher.model.Teacher;

public interface TeacherService {
	List<Teacher> getTeacher();
	
	Teacher saveTeacher(Teacher teacher);
	
	void deleteTeacher(long id);
	
	public Teacher editTeacher(Teacher teacher);
}
