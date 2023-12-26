package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.model.Teacher;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> studentDetails() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public void delete(long id) {
		studentRepository.deleteById(id);
	}
	
	@Override
	public Student edit(Student student) {
		// TODO Auto-generated method stub
		Student updateStudent = studentRepository.findById(student.getId()).orElse(null);	
		if(updateStudent!=null)
		{
			updateStudent.setId(student.getId());
			updateStudent.setName(student.getName());
			updateStudent.setStd(student.getStd());
			updateStudent.setDiv(student.getDiv());
			studentRepository.save(updateStudent);
			return updateStudent;
		}
		return null;
	}

	@Override
	public Student addTeacherByIdAndTeacherId(long id, long teacherId) {
		Student s1 = studentRepository.findById(id).get();
		Teacher t1 = new Teacher();
		t1.setTeacherId(teacherId);
		s1.setTeacherId(t1);
		
		return studentRepository.save(s1);
		
	}

}
