package com.example.intern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.dto.ResponseDto;
import com.example.intern.model.Buddy;
import com.example.intern.model.Intern;
import com.example.intern.reppository.BuddyRepository;
import com.example.intern.reppository.InternRepository;

@Service
public class InternServiceImpl implements InternService {

	@Autowired
	private InternRepository internRepository;
	
	@Autowired
	private BuddyRepository buddyRepository;
	
	// Response DTO object
	ResponseDto dto;
	
	@Override
	public ResponseDto responseDto(int status, String message, Object data) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(status);
		responseDto.setMessage(message);
		responseDto.setData(data);
		return responseDto;
	}
	
	@Override
	public ResponseDto getInternDetails() {
		dto = responseDto(200, "ok", internRepository.findAll());
		return dto;
	}

	@Override
	public ResponseDto saveIntern(Intern intern) {
		try {			
			Intern save = internRepository.save(intern);
			dto = responseDto(200, "ok", save);
		}catch(Exception e) {
			dto = responseDto(400, "Error", "Bad Request");
		}
		return dto;
	}

	@Override
	public ResponseDto deleteIntern(long id) {
		Intern intern = internRepository.findById(id).orElse(null);
		
		if(intern != null) {
			internRepository.deleteById(id);
			dto = responseDto(200, "ok", "Intern data deleted");
		}
		else {
			dto = responseDto(404, "Not found", "Intern data not found");
		}
		return dto;
	}

	@Override
	public ResponseDto addBuddyOfIntern(long iId, long bId) {
		Intern intern = internRepository.findById(iId).orElse(null);
		Buddy buddy1 = buddyRepository.findById(bId).orElse(null);
		
		if(intern != null && buddy1 != null) {
			Buddy buddy = new Buddy();
			
			buddy.setBuddyId(bId);
			intern.setBuddyOfIntern(buddy);
			
			dto = responseDto(200, "ok", internRepository.save(intern));
		}
		else {
			if(intern == null)
				dto = responseDto(404, "Not Found", "Intern data not found");
			else
				dto = responseDto(404, "Not Found", "Buddy data not found");
		}
		return dto;
		
	}

	@Override
	public ResponseDto editIntern(Intern intern) {
		Intern updateIntern = internRepository.findById(intern.getInternId()).orElse(null);
		if(updateIntern != null) {
			updateIntern.setInternId(intern.getInternId());
			updateIntern.setinternName(intern.getinternName());
			updateIntern.setInternRole(intern.getInternRole());
			updateIntern.setInternStippend(intern.getInternStippend());
			updateIntern.setBuddyOfIntern(intern.getBuddyOfIntern());
			internRepository.save(updateIntern);
			dto = responseDto(200, "ok", updateIntern);
		}
		else {
			dto = responseDto(404, "Not Found", "Intern data not updated or found");
		}
		return dto;
	}

	
}
