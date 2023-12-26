package com.example.userdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userdemo.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
