package aecomponents;

import engine.Component;
import engine.ComponentType;
import engine.Vector;

public class Velocity extends Component {

	private Vector speed;
	
	private Vector acceleration;
	
	private float friction;
	
	
	public Velocity(Vector speed) 
	{
	      setType(ComponentType.VELOCITY);
	      this.speed = speed;
	      this.acceleration = new Vector();
	      this.friction = 1f;
	}
	
	public Velocity(Vector speed, Vector acceleration)
	{
		  setType(ComponentType.VELOCITY);
	      this.speed = speed;
	      this.acceleration = acceleration;
	      this.friction = 1f;
	}
	
	public Velocity(Vector speed, Vector acceleration, float friction)
	{
		  setType(ComponentType.VELOCITY);
	      this.speed = speed;
	      this.acceleration = acceleration;
	      this.friction = 1f - friction;
	      
	      if(this.friction < 0f || this.friction > 1f)
	      {
	    	  this.friction = 1f;
	      }
	}

	public Vector getSpeed() {
		return speed;
	}

	public Vector getAcceleration() {
		return acceleration;
	}

	public float getFriction() {
		return friction;
	}
	
	public void update()
	{
		this.speed.addTo(acceleration);
		this.speed.multiplyTo(friction);
	}
	
}
