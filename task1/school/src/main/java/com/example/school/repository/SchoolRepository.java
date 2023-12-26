package com.example.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.school.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
	@Query("SELECT s FROM School as s ORDER BY s.id ASC")
	List<School> findAll();
}
