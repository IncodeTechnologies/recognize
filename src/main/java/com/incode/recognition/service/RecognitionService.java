package com.incode.recognition.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incode.recognition.domain.FacialPoint;
import com.incode.recognition.domain.Person;
import com.incode.recognition.domain.RealTimeFrame;
import com.incode.recognition.domain.Recognition;
import com.incode.recognition.domain.RecognitionRepository;

@Service
public class RecognitionService {
	
	@Autowired
	private RecognitionRepository recognitionRepository;
	
	@Autowired
	private AmazonS3Service amazonS3Service;
	
	public void save(Recognition recognition) {
		if (recognition.getPersons() != null) {
			for (Person person : recognition.getPersons()) {
				person.setRecognition(recognition);
				if (person.getFacebookId() != null) {
					List<String> urls = amazonS3Service.getUserImageLinks(person.getFacebookId());
					person.setUrls(urls);
				}
				for (FacialPoint facialPoint : person.getFacialPoints()) {
					facialPoint.setPerson(person);
				}
				
				for (RealTimeFrame realTimeFrame : person.getRealtimeFrames()) {
					realTimeFrame.setPerson(person);
					for (FacialPoint facialPoint : realTimeFrame.getFacialPoints()) {
						facialPoint.setRealTimeFrame(realTimeFrame);
					}
					
				}
			}
		}
		
		recognitionRepository.save(recognition);
	}
	
}
