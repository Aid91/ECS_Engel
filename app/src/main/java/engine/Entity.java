package engine;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Entity  {
	
	private UUID ID;
	private Map<Long,Component> components;
	private Long componentsFlag;
	private int priority;
	public Entity()
	{
		ID = UUID.randomUUID();
		componentsFlag = (long)0;
		components = new HashMap<Long, Component>();
		priority = 0;
	}
	
	public Entity(int priority)
	{
		ID = UUID.randomUUID();
		componentsFlag = (long)0;
		components = new HashMap<Long, Component>();
		this.priority = priority;
	}
	public void addComponent(Component component)
	{
		Long key = component.getType().getFlag();
		componentsFlag |= key;
		component.setEntityID(this.getID());
		components.put(key, component);
	}
	
	public Component getComponent(ComponentType type)
	{
		return components.get(type.getFlag());
	}
	
	public Long getComponentsFlag()
	{
		return componentsFlag;
	}
	
	public boolean hasComponent(ComponentType type)
	{
		return  components.containsKey(type.getFlag());
	}
	
	public UUID getID()
	{
		return ID;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
}

