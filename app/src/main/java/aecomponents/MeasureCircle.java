package aecomponents;

import engine.MeasurementType;

public class MeasureCircle extends Measure {
	
	private float radius;
	
	public MeasureCircle(float radius) 
	{
		measurementType = MeasurementType.CIRCLE;
		this.radius = radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	
}
