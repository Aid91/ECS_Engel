package aecomponents;

import engine.Component;
import engine.ComponentType;
import engine.Vector;

public class Position extends Component 
{
	private Vector point;
	
	public Position(float x, float y) {
		setType(ComponentType.POSITION);
		this.point = new Vector(x, y);
	}

	public float getX()
	{
		return point.getX();
	}
	
	public float getY()
	{
		return point.getY();
	}
	
	public Vector getPoint() {
		return point;
	}
}
