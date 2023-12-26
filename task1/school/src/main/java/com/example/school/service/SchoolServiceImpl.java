package com.example.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.dto.SchoolDto;
import com.example.school.model.School;
import com.example.school.repository.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public List<SchoolDto> getSchoolData() {
		List<SchoolDto> sDto = new ArrayList<>();
		
		List<School> s = schoolRepository.findAll();
		
		for(School sc: s) {
			SchoolDto schoolDto = new SchoolDto();
			schoolDto.setId(sc.getId());
			schoolDto.setName(sc.getName());
			schoolDto.setCity(sc.getCity());
			schoolDto.setFees(sc.getFees());
			sDto.add(schoolDto);
		}
		return sDto;
	}

	@Override
	public School save(School school) {
		return schoolRepository.save(school);
	}

	@Override
	public void delete(long id) {
		schoolRepository.deleteById(id);
	}

	@Override
	public School edit(School school) {
		School sc = schoolRepository.findById(school.getId()).orElse(null);
		if(sc != null) {
			sc.setId(school.getId());
			sc.setName(school.getName());
			sc.setCity(school.getCity());
			sc.setFees(school.getFees());
			schoolRepository.save(sc);
			return sc;
		}
		return save(school);
	}

}
