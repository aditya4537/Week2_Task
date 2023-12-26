package com.example.school.service;

import java.util.List;

import com.example.school.dto.SchoolDto;
import com.example.school.model.School;

public interface SchoolService {
	public List<SchoolDto> getSchoolData();
	
	public School save(School school);
	
	public void delete(long id);
	
	public School edit(School school);
}
