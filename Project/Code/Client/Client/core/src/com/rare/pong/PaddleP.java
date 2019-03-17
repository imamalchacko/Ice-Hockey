package com.rare.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PaddleP extends Paddle {
    private int upKey, downKey,leftKey,rightKey;

    public PaddleP(float x, float y, int upKey, int downKey, int leftKey, int rightKey, Score score) {
        super(x, y, score);
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    @Override
    public void update(float dt){
        if(!score.gameOver)
            handleInput(dt);

        super.update(dt);
    }

    private void handleInput(float dt){
        if(Gdx.input.isKeyPressed(upKey)){
            y += speed * dt;
        } else if(Gdx.input.isKeyPressed(downKey)){
            y -= speed * dt;
        }
        else if(Gdx.input.isKeyPressed(rightKey)){
            x += speed * dt;

        }
        else if(Gdx.input.isKeyPressed(leftKey)){
            x -= speed * dt;
        }
       
        clampY();
    }
}
