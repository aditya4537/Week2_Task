package com.example.intern.reppository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Intern;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {
	@Query("SELECT s FROM Intern as s ORDER BY s.internId ASC")
	List<Intern> findAll();
}
