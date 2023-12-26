package com.example.teacher.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teacher.model.Teacher;
import com.example.teacher.repository.TeacherRepository;


@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> getTeacher() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(long id) {
		teacherRepository.deleteById(id);
	}
	
	@Override
	public Teacher editTeacher(Teacher teacher) {
		Teacher updateTeacher = teacherRepository.findById(teacher.getId()).orElse(null);	
		if(updateTeacher!=null)
		{
			updateTeacher.setId(teacher.getId());
			updateTeacher.setName(teacher.getName());
			updateTeacher.setCity(teacher.getCity());
			updateTeacher.setSubject(teacher.getSubject());
			teacherRepository.save(updateTeacher);
			return updateTeacher;
		}
		return null;
	}

}
