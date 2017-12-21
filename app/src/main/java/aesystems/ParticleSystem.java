package aesystems;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.engel.Particle;

import java.util.List;

import aecomponents.Position;
import aecomponents.Velocity;
import engine.ComponentType;
import engine.Entity;
import engine.System;

/**
 * Created by aid on 26.10.17.
 */

public class ParticleSystem extends System {

    public ParticleSystem()
    {
        flag = ComponentType.PARTICLE.getFlag() | ComponentType.POSITION.getFlag();
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
        Particle particle = (Particle) entity.getComponent(ComponentType.PARTICLE);
        Position position = (Position) entity.getComponent(ComponentType.POSITION);
        Position oldPosition = new Position(position.getX(), position.getY());
        particle.update();


        position.getPoint().setX(particle.getPosition().getX());
        position.getPoint().setY(particle.getPosition().getY());

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);


        canvas.drawLine(particle.getSprings().get(0).getX(), particle.getSprings().get(0).getY(), particle.getPosition().getX(), particle.getPosition().getY(), paint);
    }
}
