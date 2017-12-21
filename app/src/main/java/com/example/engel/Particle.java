package com.example.engel;

import java.util.ArrayList;
import java.util.List;

import engine.Component;
import engine.ComponentType;
import engine.Vector;

public class Particle extends Component{

	private Vector position;
	private Vector speed;
	private Vector acceleration;
	
	private List<Spring> springs;
	
	private float friction;
	
	public Particle(Vector position, Vector speed, float friction) {
		setType(ComponentType.PARTICLE);
		this.position = position;
		this.speed = speed;
		this.acceleration = new Vector(0f,0f);
		this.friction = 1f - friction;//without friction
		this.springs = new ArrayList<Spring>();
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public Vector getSpeed() {
		return speed;
	}

	public void setSpeed(Vector speed) {
		this.speed = speed;
	}
	
	public void update()
	{
		hnadleSprings();
		speed.addTo(acceleration);
		speed.multiplyTo(friction);
		position.addTo(speed);
	}

	private void hnadleSprings() 
	{
		for(Spring spring : springs)
		{
			springTo(spring);
		}
	}

	private void springTo(Spring spring) 
	{
		Vector distance = spring.subtract(this.getPosition());
		distance.setLength(distance.getLength() - spring.getLength());
		Vector force = distance.multiply(spring.getK());
		this.getSpeed().addTo(force);
		
	}

	public Vector getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector acceleration) {
		this.acceleration = acceleration;
	}

	public float getFriction() {
		return friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}

	public List<Spring> getSprings() {
		return springs;
	}
	
	public void addSpring(Spring spring)
	{
		this.springs.add(spring);
	}
	
	public void removeSpring(Spring spring)
	{
		this.springs.remove(spring);
	}
}
