package aecomponents;

import engine.MeasurementType;
import android.graphics.Rect;

public class MeasureRectangle extends Measure {
	
	private Rect rectangle;
	
	public MeasureRectangle(int width, int height) 
	{
		measurementType = MeasurementType.RECTANGLE;
		this.rectangle = new Rect();
		this.rectangle.right = width;
		this.rectangle.bottom = height;
	}
	
	
	public Rect getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rect rectangle) {
		this.rectangle = rectangle;
	}

	public int getWidth()
	{
		return rectangle.right;
	}
	
	public int getHeight()
	{
		return rectangle.bottom;
	}
	
}
