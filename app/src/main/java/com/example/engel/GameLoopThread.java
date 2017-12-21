package com.example.engel;

import aecomponents.Measure;
import aecomponents.MeasureCircle;
import aecomponents.Position;
import aecomponents.Sprite;
import aecomponents.Velocity;
import aesystems.ParticleSystem;
import aetools.Tools;
import engine.Entity;
import managment.EntityFactory;
import managment.EntityManager;
import engine.Engine;
import engine.Vector;
import aesystems.MovementSystem;
import aesystems.RenderSystem;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameLoopThread extends Thread {

	private static final String tag = GameLoopThread.class.getSimpleName();
	private static int FPS = 60;
	private static int FRAME_PERIOD = 1000/FPS;
	private static int MAX_FRAME_SKIPS = 5;
	private GamePanel view;
	private SurfaceHolder holder;
	private boolean running;
	
	private Engine engine;
	//test
	private Vector springPoint;

	private Spring spring;

	private Spring spring2;

	private Particle particle;

    private MovementSystem movementSystem;

    private RenderSystem renderSystem;

    private ParticleSystem particleSystem;

	//test
	public GameLoopThread(GamePanel view) {
		this.view = view;
		this.running = false;
		this.holder = view.getHolder();
		this.springPoint = new Vector(view.getWidth()/2, view.getHeight()/2);
		
		this.engine = new Engine();
		EntityManager.Initialize();
		Rect screenRect = new Rect();
		screenRect.right = this.view.getWidth();
		screenRect.bottom = this.view.getHeight();
		renderSystem = new RenderSystem(screenRect, Color.WHITE);
		movementSystem = new MovementSystem();
        particleSystem = new ParticleSystem();

		engine.addSystem(movementSystem);
		engine.addSystem(renderSystem);
		engine.addSystem(particleSystem);

		Vector position = new Vector(this.springPoint.getX(), this.springPoint.getY());
		Vector speed = new Vector(Tools.randInt(0, 10), Tools.randInt(0, 10));

		particle = new Particle(position, speed, 0.1f);
        spring = new Spring(this.springPoint.getX(), this.springPoint.getY(), 0.1f, 0f);
		particle.addSpring(spring);

		Entity entity = createRandomCircleEntity();
		entity.addComponent(particle);

		EntityManager.addEntity(entity);
	}

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
	
	
	public boolean isRunning() {
		return running;
	}


	public void setRunning(boolean running) {
		this.running = running;
	}


	public Spring getSpring() {return spring;}
    public Spring getSpring2() {return spring2;}

	public Particle getParticle() {return particle;}
	
	public Vector getSpringPoint() {
		return springPoint;
	}

	public void removeMovementSystem() {
	   this.engine.removeSystem(this.movementSystem);
    }

    public void addMovementSystem() {
	    this.engine.addSystem(this.movementSystem);
    }


	@Override
	public void run() {
		long startTime;
		long sleepTime;
		int frameSkipped;
		while(running)
		{
			Canvas canvas = null;
			try
			{
				canvas = holder.lockCanvas();
				synchronized (holder) {
					startTime = System.currentTimeMillis();
					frameSkipped = 0;
					if(canvas != null)
					{
						engine.update(0, canvas, EntityManager.getEntities());
					}
					sleepTime = FRAME_PERIOD -(System.currentTimeMillis() - startTime);
					
					if(sleepTime > 0)
					{
						try
						{
							Log.d(tag, "Sleep for: " + sleepTime);
							Thread.sleep(sleepTime);
						}
						catch(InterruptedException exception){}
					}
					//Check for flickering at this position of "catch up" loop.
					
				}
			}
			finally
			{
				if(canvas!=null)
				{
					holder.unlockCanvasAndPost(canvas);
				}
			}
			
			while(sleepTime < 0 && frameSkipped < MAX_FRAME_SKIPS)
			{
				//update without render
				sleepTime +=FRAME_PERIOD;
				frameSkipped++;
			}
			
			if(frameSkipped>0)
			{
				Log.d(tag, "Frames skipped: " + frameSkipped);
			}
			
			EntityManager.updateEntities();
		}
		Log.d(tag, "Exiting from GameLoop.");
	}

}
