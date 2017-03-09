package com.incode.recognition.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.incode.recognition.domain.Recognition;
import com.incode.recognition.service.RecognitionService;

@RestController
public class RecognitionController {
	
	@Autowired
	private RecognitionService recognitionService;
	
	@PostMapping("/recognition")
	public void recognition(@Valid @RequestBody Recognition recognition) {
		recognitionService.save(recognition);
	}
	
}
