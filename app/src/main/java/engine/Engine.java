package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import android.graphics.Canvas;
import android.util.Log;

public class Engine {
    private List<System> systems;
    private static final String tag = Engine.class.getSimpleName();

    public Engine() {
        Log.d(tag, "New Engine.");
        systems = new ArrayList<System>();
    }

    public void update(float dt, Canvas canvas, List<Entity> entities) {
        try {
            for (System system : systems) {
                system.update(dt, entities, canvas);
            }
        } catch (Exception e) {
            Log.d(tag, "Trying to modify system in loop!");
        }

    }

    public void addSystem(System system) {
        systems.add(system);
    }

    public void removeSystem(System system) {
        try {
            if (systems.contains(system)) {
                systems.remove(system);
            }
        } catch (Exception e) {
            Log.d(tag, "Trying to modify system in loop!");
        }

    }
}
