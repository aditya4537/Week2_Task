package com.example.school.controller;

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

import com.example.school.dto.SchoolDto;
import com.example.school.model.School;
import com.example.school.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/get")
	public List<SchoolDto> getData(){
		return schoolService.getSchoolData();
	}
	
	@PostMapping("/add")
	public School addData(@RequestBody School school){
		return schoolService.save(school);
	}
	
	@DeleteMapping("/delete")
	public void deleteData(@RequestParam("id") long id) {
		schoolService.delete(id);
	}
	
	@PutMapping("/edit")
	public School editData(@RequestBody School school) {
		return schoolService.edit(school);
	}
}
