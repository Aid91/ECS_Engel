package engine;

import java.util.UUID;

public class Component {
	
	private UUID entityID;
	private ComponentType type;

	public ComponentType getType() 
	{
		return type;
	}

	public UUID getEntityID() 
	{
		return entityID;
	}

	public void setEntityID(UUID entityID) 
	{
		this.entityID = entityID;
	}

	protected void setType(ComponentType type) 
	{
		this.type = type;
	}
}
