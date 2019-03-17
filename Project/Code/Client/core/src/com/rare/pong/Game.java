package com.rare.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Game implements Screen {
    protected Puck puck;
    protected Pong pong;
    protected Score score;
    private ShapeRenderer shapeRenderer;
    protected Paddle leftP, rightP;
    public Game(Pong pong){
        this.pong = pong;
        score = new Score(pong);
        puck = new Puck(score);
        shapeRenderer = new ShapeRenderer();
        puck.checkPaddles = true;
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        score.update();
        leftP.update(delta);
        rightP.update(delta);
        puck.update(delta, leftP, rightP);


        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(88,8,8,3));
        for(int i = 0; i < Gdx.graphics.getHeight(); i+=2){
            shapeRenderer.rect(Gdx.graphics.getWidth()/2f - 10f/2,  i * 20f, 10f, 200f);
        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        puck.dispose();
        score.dispose();
        shapeRenderer.dispose();
        leftP.dispose();
        rightP.dispose();
    }

    @Override
    public void show() {}
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
}
