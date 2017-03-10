package com.incode.recognition.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Recognition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String photoUrl;
	private Long faceDetectionTimeMs;
	
	private Long facialPointsDetectionTimeMs;
	private String softwareVersion;
	private String clientType;
	
	private String faceDetectorType;
	private String recognitionVersion;
	
	@CreationTimestamp
	private Date creationDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recognition")
	private List<Person> persons;
	
	@Embedded
	private CameraSettings cameraSettings;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}
	
	public Long getFaceDetectionTimeMs() {
		return faceDetectionTimeMs;
	}
	
	public void setFaceDetectionTimeMs(Long faceDetectionTimeMs) {
		this.faceDetectionTimeMs = faceDetectionTimeMs;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public String getClientType() {
		return clientType;
	}
	
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	public String getFaceDetectorType() {
		return faceDetectorType;
	}
	
	public void setFaceDetectorType(String faceDetectorType) {
		this.faceDetectorType = faceDetectorType;
	}
	
	public Long getFacialPointsDetectionTimeMs() {
		return facialPointsDetectionTimeMs;
	}
	
	public void setFacialPointsDetectionTimeMs(Long facialPointsDetectionTimeMs) {
		this.facialPointsDetectionTimeMs = facialPointsDetectionTimeMs;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public CameraSettings getCameraSettings() {
		return cameraSettings;
	}
	
	public void setCameraSettings(CameraSettings cameraSettings) {
		this.cameraSettings = cameraSettings;
	}
	
	public String getRecognitionVersion() {
		return recognitionVersion;
	}
	
	public void setRecognitionVersion(String recognitionVersion) {
		this.recognitionVersion = recognitionVersion;
	}
	
}
