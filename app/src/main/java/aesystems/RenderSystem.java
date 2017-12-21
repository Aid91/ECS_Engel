package aesystems;
import java.util.List;

import aecomponents.Measure;
import aecomponents.MeasureCircle;
import aecomponents.MeasureRectangle;
import aecomponents.Position;
import aecomponents.Sprite;
import android.content.pm.PackageInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import engine.Component;
import engine.ComponentType;
import engine.Entity;
import engine.System;


public class RenderSystem extends System {

	private int color;
	private Rect screenRect;
	public RenderSystem(Rect screenRect, int color) 
	{
		flag = ComponentType.POSITION.getFlag() | ComponentType.MEASURE.getFlag() | ComponentType.SPRITE.getFlag();
		this.color = color; 
		this.screenRect = screenRect;
	}
	
	@Override
	public void update(float dt, List<Entity> entities, Canvas canvas) 
	{
		ClearCanvas(canvas);
		for(Entity entity : entities)
		{
			if((flag & entity.getComponentsFlag()) == flag)
			{
				RenderEntity(entity, canvas);
			}
		}
	}


	private void RenderEntity(Entity entity, Canvas canvas) 
	{
		Position position = (Position) entity.getComponent(ComponentType.POSITION);
		Measure measure = (Measure) entity.getComponent(ComponentType.MEASURE);
		Sprite sprite = (Sprite) entity.getComponent(ComponentType.SPRITE);
		Paint paint = new Paint();
		paint.setColor(sprite.getColor());
		
		switch (measure.getMeasurementType()) {
		case RECTANGLE: {
			MeasureRectangle measureRectangle = (MeasureRectangle)measure;
			Rect rect = new Rect();
			rect.left = (int) position.getX();
			rect.top = (int) position.getY();
			rect.right = rect.left + measureRectangle.getWidth();
			rect.bottom = rect.top + measureRectangle.getHeight();
			canvas.drawRect(rect, paint);
			break;
		}
		case CIRCLE: {
			MeasureCircle measureCircle = (MeasureCircle) measure;
			canvas.drawCircle(position.getX(), position.getY(),
					measureCircle.getRadius(), paint);
			break;
		}
		}
		
		
	}

	private void ClearCanvas(Canvas canvas) 
	{
		Paint paint = new Paint();
		paint.setColor(color);
		canvas.drawRect(screenRect, paint);
	}
}
