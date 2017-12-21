package engine;

import java.util.List;
import java.util.PriorityQueue;

import android.graphics.Canvas;

public abstract class System 
{
	protected long flag;
	public abstract void update(float dt, List<Entity> entities, Canvas canvas);
}
