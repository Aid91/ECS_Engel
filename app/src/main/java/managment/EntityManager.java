package managment;

import java.util.ArrayList;
import java.util.List;

import engine.Entity;

public class EntityManager 
{
	private static List<Entity> listEntities; 
	private static List<Entity> deleteEntities;
	private static List<Entity> addEntities;
	private static Object lock;
	public static void addEntity( Entity entity)
	{
		synchronized (lock) {
			addEntities.add(entity);
		}
	}
	
	public static void removeEntity( Entity entity)
	{
		synchronized(lock)
		{
			deleteEntities.add(entity);
		}
	}
	
	public static void updateEntities()
	{
		synchronized (lock) {
			for (Entity entity : deleteEntities) {
				listEntities.remove(entity);
			}
			deleteEntities.clear();
			for (Entity entity : addEntities)
			{
				listEntities.add(entity);
			}
			addEntities.clear();
		}
	}
	
	public static List<Entity> getEntities()
	{
		return listEntities;
	}

	public static void Initialize() 
	{
		
		deleteEntities = new ArrayList<Entity>();
		addEntities = new ArrayList<Entity>();
		lock = new Object();
		listEntities = new ArrayList<Entity>();
	}
	
	public static void clearAll()
	{
		synchronized (lock) {
			deleteEntities.clear();
			listEntities.clear();
			addEntities.clear();
		}
	}
	
}
