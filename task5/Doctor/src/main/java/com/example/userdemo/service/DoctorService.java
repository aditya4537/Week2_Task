package com.example.userdemo.service;

import java.util.List;

import com.example.userdemo.model.Doctor;

public interface DoctorService {
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(int id);
	
	public Doctor addDoctor(Doctor doctor);
	
	public void deleteDoctorById(int id);
}
