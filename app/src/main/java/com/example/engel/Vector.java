package com.example.engel;

public class Vector {
	private float x;
	private float y;
	
	public Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void setAngle(double angle)
	{
		this.x = (float) (Math.cos(angle) * getLength());
		this.y = (float) (Math.sin(angle) * getLength());
	}
	
	public double getAngle()
	{
		return Math.atan2(this.y, this.x);
	}
	
	public void setLength(float length)
	{
		this.x = (float) (Math.cos(getAngle()) * length);
		this.y = (float) (Math.sin(getAngle()) * length);
	}
	
	public double getLength()
	{
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
	
	public Vector add(Vector other)
	{
		float x1 = this.x + other.getX();
		float y1 = this.y + other.getY();
		return new Vector(x1, y1);
	}
	
	public Vector subtract(Vector other)
	{
		float x1 = this.x - other.getX();
		float y1 = this.y - other.getY();
		return new Vector(x1, y1);
	}
	
	public Vector multiply( double scale)
	{
		float x1 = (float) (this.x * scale);
		float y1 = (float) (this.y*scale);
		return new Vector(x1, y1);
	}
	
	public Vector divide( double scale)
	{
		float x1 = (float) (this.x/scale);
		float y1 = (float) (this.y/scale);
		return new Vector(x1, y1);
	}
	
	public void addTo(Vector other)
	{
		this.x += other.getX();
		this.y += other.getY();
	}
	
	public void subtractTo(Vector other)
	{
		this.x -= other.getX();
		this.y -= other.getY();
	}
	
	public void multiplyTo( double scale)
	{
		this.x *= scale;
		this.y *= scale;
	}
	
	public void divideTo( double scale)
	{
		this.x /= scale;
		this.y /= scale;
	}
	
	
}
