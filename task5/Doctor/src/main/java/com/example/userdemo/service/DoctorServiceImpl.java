package com.example.userdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userdemo.Exception.DoctorNotFoundException;
import com.example.userdemo.model.Doctor;
import com.example.userdemo.repository.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepo doctorRepo;


	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}
	
	@Override
	public Doctor getDoctorById(int id) {
		Doctor d = doctorRepo.findById(id).orElseThrow(() -> new DoctorNotFoundException("Doctor not found. Please enter the valid Doctor!"));
		return d;
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public void deleteDoctorById(int id) {
		if(getDoctorById(id) != null) {
			doctorRepo.deleteById(id);
		}
		else {
			throw new DoctorNotFoundException("Doctor Not Found");
		}
		
	}


}
