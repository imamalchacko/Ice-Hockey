package com.rare.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class PaddleAI extends Paddle {
    private Puck puck;

    public PaddleAI(float x, float y, Score score, Puck puck) {
        super(x, y, score);
        this.puck = puck;
    }

    @Override
    public void update(float dt){
        if(!score.gameOver)
            handleMovement(dt);

        super.update(dt);
    }

    private void handleMovement(float dt){ // AI
        if(y + height/2 < Gdx.graphics.getHeight()/2 && puck.getPos().y + puck.getSize()/2 > Gdx.graphics.getHeight()/2 && puck.getVel().y > 0)
            speed = maxSpeed;
        else if (y + height/2 > Gdx.graphics.getHeight()/2 && puck.getPos().y + puck.getSize()/2 < Gdx.graphics.getHeight()/2 && puck.getVel().y < 0)
            speed = -maxSpeed;
        else if(y + height/2 < Gdx.graphics.getHeight()/2 && Math.abs(y + height/2 - puck.getPos().y - puck.getSize()/2) > 30 && puck.getVel().len() < 520)
            speed = maxSpeed;
        else if (y + height/2 > Gdx.graphics.getHeight()/2 && Math.abs(y + height/2 - puck.getPos().y - puck.getSize()/2) > 30 && puck.getVel().len() < 520)
            speed = -maxSpeed;
        else {
            speed = puck.getVel().y * MathUtils.random(0.985f, 1.085f);
            speed = MathUtils.clamp(speed, -maxSpeed, maxSpeed);
        }
        y += speed * dt;

        clampY();
    }
}
