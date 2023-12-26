package com.example.intern.service;

import com.example.intern.dto.ResponseDto;
import com.example.intern.model.Intern;

public interface InternService {
	public ResponseDto getInternDetails();
	
	public ResponseDto saveIntern(Intern intern);
	
	public ResponseDto deleteIntern(long id);
	
	public ResponseDto editIntern(Intern intern);
	
	public ResponseDto addBuddyOfIntern(long iId, long bId);
	
	public ResponseDto responseDto(int status,String message, Object data);
	
}
