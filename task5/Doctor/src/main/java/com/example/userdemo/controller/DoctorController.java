package com.example.userdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userdemo.dto.ResponseDto;
import com.example.userdemo.model.Doctor;
import com.example.userdemo.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	
	@GetMapping("/get/{id}")
	public Doctor getDoctorById(@PathVariable("id") int id) {
		return doctorService.getDoctorById(id);
	}

	@GetMapping("/getAll")
	public List<Doctor> getDoctorById() {
		return doctorService.getAllDoctors();
	}
	
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseDto deleteDoctorById(@PathVariable("id") int id) {
		doctorService.deleteDoctorById(id);
		return new ResponseDto(200, "ok", "Doctor Data deleted");
	}
}
