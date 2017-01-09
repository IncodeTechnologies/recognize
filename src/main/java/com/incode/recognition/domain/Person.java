package com.incode.recognition.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "url", joinColumns = @JoinColumn(name = "person_id"))
	@Column(name = "url")
	private List<String> urls;

	@ManyToOne
	@JoinColumn(name = "recognition_id", nullable = false)
	private Recognition recognition;

	@Embedded
	private FacialPoints facialPoints;

	private Long faceRecognitionTimeMs;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "y", column = @Column(name = "facialRectangleY")),
			@AttributeOverride(name = "x", column = @Column(name = "facialRectangleX")),
			@AttributeOverride(name = "w", column = @Column(name = "facialRectangleW")),
			@AttributeOverride(name = "h", column = @Column(name = "facialRectangleH")) })
	private FaceRectangle facialRectangle;

	@Lob
	private String croppedFaceBase64;

	private String personId;
	private String facebookId;

	private Boolean falsePositive;
	private Boolean recognized;

	private Float confidenceLevel;

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public FacialPoints getFacialPoints() {
		return facialPoints;
	}

	public void setFacialPoints(FacialPoints facialPoints) {
		this.facialPoints = facialPoints;
	}

	public String getCroppedFaceBase64() {
		return croppedFaceBase64;
	}

	public void setCroppedFaceBase64(String croppedFaceBase64) {
		this.croppedFaceBase64 = croppedFaceBase64;
	}

	public FaceRectangle getFacialRectangle() {
		return facialRectangle;
	}

	public void setFacialRectangle(FaceRectangle facialRectangle) {
		this.facialRectangle = facialRectangle;
	}

	public Boolean getFalsePositive() {
		return falsePositive;
	}

	public void setFalsePositive(Boolean falsePositive) {
		this.falsePositive = falsePositive;
	}

	public Boolean getRecognized() {
		return recognized;
	}

	public void setRecognized(Boolean recognized) {
		this.recognized = recognized;
	}

	public Float getConfidenceLevel() {
		return confidenceLevel;
	}

	public void setConfidenceLevel(Float confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public Recognition getRecognition() {
		return recognition;
	}

	public void setRecognition(Recognition recognition) {
		this.recognition = recognition;
	}

	public Long getFaceRecognitionTimeMs() {
		return faceRecognitionTimeMs;
	}

	public void setFaceRecognitionTimeMs(Long faceRecognitionTimeMs) {
		this.faceRecognitionTimeMs = faceRecognitionTimeMs;
	}

}
