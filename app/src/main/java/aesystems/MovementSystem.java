package aesystems;

import java.util.List;

import aecomponents.Position;
import aecomponents.Velocity;
import android.graphics.Canvas;
import engine.ComponentType;
import engine.Entity;
import engine.System;

public class MovementSystem extends System {

	public MovementSystem() 
	{
		flag = ComponentType.POSITION.getFlag() | ComponentType.VELOCITY.getFlag();
	}
	
	
	@Override
	public void update(float dt, List<Entity> entities, Canvas canvas) {
		
		for(Entity entity : entities)
		{
			if((flag & entity.getComponentsFlag()) == flag)
			{
				UpdateEntity(entity, canvas);
			}
		}
	}


	private void UpdateEntity(Entity entity, Canvas canvas) 
	{
		Velocity velocity = (Velocity) entity.getComponent(ComponentType.VELOCITY);
		Position position = (Position) entity.getComponent(ComponentType.POSITION);
		velocity.update();
		position.getPoint().addTo(velocity.getSpeed());
	}
}
