package com.example.engel;

import engine.Vector;

public class Spring extends Vector
{
	private float k;
	private float length;
	public Spring(float x, float y, float k, float lenght) {
		super(x, y);
		this.k = k;
		this.length = lenght;
	}
	public float getK() {
		return k;
	}
	public void setK(float k) {
		this.k = k;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	
	
}
