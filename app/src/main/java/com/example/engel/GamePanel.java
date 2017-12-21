package com.example.engel;

import java.lang.Thread.State;

import android.content.Context;
import android.icu.text.DateFormat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import engine.Entity;
import managment.EntityManager;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

	private GameLoopThread mainThread;
	private Boolean isPaused = false;
	public GamePanel(Context context) {
		super(context);
		getHolder().addCallback(this);
//		mainThread = new GameLoopThread(this);
		setFocusable(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if(mainThread == null || mainThread.getState() != State.NEW)
		{
			mainThread = new GameLoopThread(this);
		}
		mainThread.setRunning(true);
		mainThread.start();
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		mainThread.setRunning(false);
		while(retry)
		{
			try
			{
				mainThread.join();
				retry = false;
			}catch(InterruptedException exception){}
		}
	
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch(event.getAction())
		{
		case MotionEvent.ACTION_MOVE:
			mainThread.getSpringPoint().setX(event.getX());
			mainThread.getSpringPoint().setY(event.getY());

			mainThread.getSpring().setX(event.getX());
			mainThread.getSpring().setY(event.getY());

			//mainThread.getSpring2().setX(event.getX());
			//mainThread.getSpring2().setY(event.getY());

			//mainThread.getParticle().getPosition().setX(event.getX());
			//mainThread.getParticle().getPosition().setY(event.getY());

			break;
            case MotionEvent.ACTION_DOWN:
                isPaused = !isPaused;
                if(isPaused) {
                    mainThread.removeMovementSystem();
                }
                else {
                    mainThread.addMovementSystem();
                }

                break;
		}
		return true;
	}
	

}
