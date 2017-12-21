package managment;

import aecomponents.Measure;
import aecomponents.MeasureCircle;
import aecomponents.MeasureRectangle;
import aecomponents.Position;
import aecomponents.Sprite;
import aecomponents.Velocity;
import aetools.Tools;
import android.graphics.Color;

import com.example.engel.Particle;

import engine.ComponentType;
import engine.Entity;
import engine.Vector;

public class EntityFactory 
{
	public static Entity createRandomCircleEntity()
	{
		Entity entity = new Entity();
		Position position = new Position(Tools.randInt(0, 700), Tools.randInt(0, 1000));
		Measure measure = new MeasureCircle(Tools.randInt(20, 100));
		Sprite sprite = new Sprite(Color.RED);
		entity.addComponent(sprite);
		entity.addComponent(measure);
		entity.addComponent(position);
		return entity;
	}
	
	
	public static Entity createVelocityEntity()
	{
		Entity entity = createRandomCircleEntity();
		
		Vector speed = new Vector(Tools.randInt(-10, 10), Tools.randInt(-9, 9));
		Velocity velocity = new Velocity(speed);
		entity.addComponent(velocity);
		
		return entity;
	}
	
	public static Entity createRandomRectangleEntity()
	{
		Entity entity = new Entity();
		Position position = new Position(Tools.randInt(0, 700), Tools.randInt(0, 1000));
		Measure measure = new MeasureRectangle(Tools.randInt(20, 100),Tools.randInt(20, 100));
		Sprite sprite = new Sprite(Color.GRAY);
		entity.addComponent(sprite);
		entity.addComponent(measure);
		entity.addComponent(position);
		return entity;
	}
	
	public static Entity createVelocityRectangleEntity()
	{
		Entity entity = createRandomRectangleEntity();
		
		Vector speed = new Vector(Tools.randInt(-10, 10), Tools.randInt(-9, 9));
		Velocity velocity = new Velocity(speed);
		entity.addComponent(velocity);
		
		return entity;
	}
}
