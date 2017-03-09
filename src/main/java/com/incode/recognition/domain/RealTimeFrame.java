package com.incode.recognition.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RealTimeFrame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long frameId;
	
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "realTimeFrame")
	private List<FacialPoint> facialPoints;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "y", column = @Column(name = "facialRectangleY")),
			@AttributeOverride(name = "x", column = @Column(name = "facialRectangleX")),
			@AttributeOverride(name = "w", column = @Column(name = "facialRectangleW")),
			@AttributeOverride(name = "h", column = @Column(name = "facialRectangleH")) })
	private FacialRectangle facialRectangle;
	
	private Double confidence;
	private String predictedPersonID;
	private Long templateCreationTimeMs;
	private Long predictionTimeMs;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getFrameId() {
		return frameId;
	}
	
	public void setFrameId(Long frameId) {
		this.frameId = frameId;
	}
	
	public Double getConfidence() {
		return confidence;
	}
	
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
	
	public String getPredictedPersonID() {
		return predictedPersonID;
	}
	
	public void setPredictedPersonID(String predictedPersonID) {
		this.predictedPersonID = predictedPersonID;
	}
	
	public Long getTemplateCreationTimeMs() {
		return templateCreationTimeMs;
	}
	
	public void setTemplateCreationTimeMs(Long templateCreationTimeMs) {
		this.templateCreationTimeMs = templateCreationTimeMs;
	}
	
	public Long getPredictionTimeMs() {
		return predictionTimeMs;
	}
	
	public void setPredictionTimeMs(Long predictionTimeMs) {
		this.predictionTimeMs = predictionTimeMs;
	}
	
	public List<FacialPoint> getFacialPoints() {
		return facialPoints;
	}
	
	public void setFacialPoints(List<FacialPoint> facialPoints) {
		this.facialPoints = facialPoints;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public FacialRectangle getFacialRectangle() {
		return facialRectangle;
	}
	
	public void setFacialRectangle(FacialRectangle facialRectangle) {
		this.facialRectangle = facialRectangle;
	}
	
}
