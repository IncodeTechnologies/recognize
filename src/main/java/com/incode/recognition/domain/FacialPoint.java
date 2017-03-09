package com.incode.recognition.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FacialPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Float x;
	private Float y;
	
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = true)
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "frame_id", nullable = true)
	private RealTimeFrame realTimeFrame;
	
	public Float getX() {
		return x;
	}
	
	public void setX(Float x) {
		this.x = x;
	}
	
	public Float getY() {
		return y;
	}
	
	public void setY(Float y) {
		this.y = y;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public RealTimeFrame getRealTimeFrame() {
		return realTimeFrame;
	}
	
	public void setRealTimeFrame(RealTimeFrame realTimeFrame) {
		this.realTimeFrame = realTimeFrame;
	}
	
}
