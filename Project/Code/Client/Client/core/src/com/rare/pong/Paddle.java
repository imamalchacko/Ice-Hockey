package com.rare.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public abstract class Paddle {
    protected float x, y;
    protected float width = 15f;
    protected float height = 100f;
    protected float speed = 600f;
    protected final int maxSpeed = 600;
    protected Score score;
    private ShapeRenderer shapeRenderer;

    public Paddle(float x, float y, Score score) {
        this.x = x;
        this.y = y;
        this.score = score;
        shapeRenderer = new ShapeRenderer();
    }

    public void update(float dt){
        draw();
    }

    private void draw(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.ellipse(x, y, width+10, height-20);
        shapeRenderer.setColor(new Color(255,0,0,1));
        shapeRenderer.end();
    }

    protected void clampY(){
        y = MathUtils.clamp(y, 0, Gdx.graphics.getHeight() - height);
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    float getWidth() {
        return width;
    }

    float getHeight() {
        return height;
    }

    public void dispose(){
        shapeRenderer.dispose();
    }
}
