package com.incode.recognition.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;

public class FacialPoints {

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "y", column = @Column(name = "rightEyeY")),
			@AttributeOverride(name = "x", column = @Column(name = "rightEyeX")) })
	private Point rightEye;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "y", column = @Column(name = "leftEyeY")),
			@AttributeOverride(name = "x", column = @Column(name = "leftEyeX")) })
	private Point leftEye;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "y", column = @Column(name = "centerMouthY")),
			@AttributeOverride(name = "x", column = @Column(name = "centerMouthX")) })
	private Point centerMouth;

	public Point getRightEye() {
		return rightEye;
	}

	public void setRightEye(Point rightEye) {
		this.rightEye = rightEye;
	}

	public Point getLeftEye() {
		return leftEye;
	}

	public void setLeftEye(Point leftEye) {
		this.leftEye = leftEye;
	}

	public Point getCenterMouth() {
		return centerMouth;
	}

	public void setCenterMouth(Point centerMouth) {
		this.centerMouth = centerMouth;
	}

}
