package com.example.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teacher.dto.TeacherDto;
import com.example.teacher.model.Teacher;
import com.example.teacher.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/get")
	public List<Teacher> getAllTeachers() {
		 return teacherService.getTeacher();
	}
	
	@PostMapping("/add")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<TeacherDto> deleteTeacher(@RequestParam("id") long id) {
		teacherService.deleteTeacher(id);
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setData("Teacher data deleted");
		teacherDto.setMessage("ok");
		teacherDto.setStatus(200);
		return new ResponseEntity<>(teacherDto,HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/edit")
	public Teacher editTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.editTeacher(teacher);
	}
}
