package engine;

public enum ComponentType {
	POSITION(1),
	SPRITE(2),
	MEASURE(3),
	COLLISION(4),
	PARTICLE(5),
	VELOCITY(6);
	
	private long flag;
	
	ComponentType(long value)
	{
		this.flag = 1<<value;
	}

	public long getFlag() {
		return flag;
	}
	
}
