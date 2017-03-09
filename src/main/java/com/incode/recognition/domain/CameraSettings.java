package com.incode.recognition.domain;

public class CameraSettings {
	
	private String orientation;
	
	private Integer frameRate;
	
	private Long freeMemory;
	
	public String getOrientation() {
		return orientation;
	}
	
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public Integer getFrameRate() {
		return frameRate;
	}
	
	public void setFrameRate(Integer frameRate) {
		this.frameRate = frameRate;
	}
	
	public Long getFreeMemory() {
		return freeMemory;
	}
	
	public void setFreeMemory(Long freeMemory) {
		this.freeMemory = freeMemory;
	}
	
}
