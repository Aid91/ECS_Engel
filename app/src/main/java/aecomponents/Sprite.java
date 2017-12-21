package aecomponents;

import engine.Component;
import engine.ComponentType;

public class Sprite extends Component 
{
	private int color;
	public Sprite(int color) 
	{
		setType(ComponentType.SPRITE);
		this.color = color;
	}
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
}
