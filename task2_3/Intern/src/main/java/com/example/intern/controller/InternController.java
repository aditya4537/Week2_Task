package com.example.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.dto.ResponseDto;
import com.example.intern.model.Intern;
import com.example.intern.service.InternService;

@RestController
@RequestMapping("/intern")
public class InternController {

	@Autowired
	private InternService internService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDto> getInterns(){
		ResponseDto rd =  internService.getInternDetails();
		return new ResponseEntity<>(rd ,HttpStatusCode.valueOf(rd.getStatus()));
	}
	
	@PostMapping("/add")
	public ResponseEntity<ResponseDto> addIntern(@RequestBody Intern intern) {
		ResponseDto rd =  internService.saveIntern(intern);
		return new ResponseEntity<>(rd ,HttpStatusCode.valueOf(rd.getStatus()));
	}
	
	@DeleteMapping("/delete/{internId}")
	public ResponseEntity<ResponseDto> deleteIntern(@PathVariable() long internId) {
		ResponseDto rd_delete = internService.deleteIntern(internId);
		
		return new ResponseEntity<>(rd_delete ,HttpStatusCode.valueOf(rd_delete.getStatus()));	
	}
	
	@PutMapping("/edit")
	public ResponseEntity<ResponseDto> editIntern(@RequestBody Intern intern) {
		ResponseDto rd_edit = internService.editIntern(intern);
		return new ResponseEntity<>(rd_edit ,HttpStatusCode.valueOf(rd_edit.getStatus()));
	}
	
	@PutMapping("/addBuddy")
	public ResponseEntity<ResponseDto> addBuddyOfIntern(@RequestParam("iId") long internId, @RequestParam("bId") long buddyId) {
		ResponseDto rd = internService.addBuddyOfIntern(internId, buddyId);
		return new ResponseEntity<>(rd ,HttpStatusCode.valueOf(rd.getStatus()));
	}
}
