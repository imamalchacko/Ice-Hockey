package com.rare.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Puck {
    private Vector2 pos = new Vector2(Gdx.graphics.getWidth()/2f - 15f/2f, Gdx.graphics.getHeight()/2f - 15f/2f);
    private Vector2 vel;
    private float size = 15f;
    private int maxSpeed = 1000;
    private int minSpeed = 400;
    private float speed;
    private float accelerationPercent = 1.002f;
    public boolean checkPaddles = false;
    private ShapeRenderer shapeRenderer;
    private Score score;
    private Sound blip1;
    private Sound blip2;
    private Sound blip3;
    private final float soundVolume = 0.2f;

    public Puck(Score score){
        reset();
        shapeRenderer = new ShapeRenderer();
        this.score = score;

    }

    public void update(float dt, Paddle leftP, Paddle rightP){
        if(!score.gameOver) {
            glide(dt);

            if(checkPaddles)
                checkCollisions(leftP, rightP);

            if (vel.len() <= maxSpeed) {
                vel.scl(accelerationPercent, accelerationPercent);
                speed *= accelerationPercent;
            }
        }

        draw();
    }

    public void draw(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(pos.x, pos.y,15);
        shapeRenderer.end();
    }

    public void glide(float dt){
        pos.add(new Vector2(vel.x * dt, vel.y * dt));

        if(checkPaddles) {
            if (pos.x <= -size) {
                reset();
                score.scoreRight();
            } else if (pos.x >= Gdx.graphics.getWidth()) {
                reset();
                score.scoreLeft();
            }
        } else {
            if (pos.x <= 0f) {
                vel.scl(-1f, 1f);
                pos.set(0f, pos.y);

            } else if (pos.x >= Gdx.graphics.getWidth() - size) {
                vel.scl(-1f, 1f);
                pos.set(Gdx.graphics.getWidth() - size, pos.y);

            }
        }

        if(pos.y <= 0f) {
            vel.scl(1f, -1f);
            pos.set(pos.x, 0f);

        } else if(pos.y >= Gdx.graphics.getHeight() - size){
            vel.scl(1f, -1f);
            pos.set(pos.x, Gdx.graphics.getHeight() - size);

        }
    }

    private void checkCollisions(Paddle leftP, Paddle rightP){
        if(pos.y <= leftP.getY() + leftP.getHeight() && pos.y + size >= leftP.getY() && pos.x <= leftP.getX() + leftP.getWidth() && pos.x + size >= leftP.getX() + leftP.getWidth()/2f) {

            float diff = (pos.y + size/2f) - (leftP.getY() + leftP.getHeight()/2f);
            float angle = diff / (leftP.getHeight()/2f) * 45f;
            angle = MathUtils.clamp(angle, -45f, 45f) * MathUtils.degRad;
            vel = new Vector2(Math.abs(speed * MathUtils.cos(angle)), Math.abs(speed) * MathUtils.sin(angle));
            pos.set(leftP.getX() + leftP.getWidth(), pos.y);

        } else if(pos.y <= rightP.getY() + rightP.getHeight() && pos.y + size >= rightP.getY() && pos.x + size >= rightP.getX() && pos.x <= rightP.getX() + rightP.getWidth()/2f) {

            float diff = (pos.y + size/2f) - (rightP.getY() + rightP.getHeight()/2f);
            float angle = diff / (rightP.getHeight()/2f) * 45f;
            angle = MathUtils.clamp(angle, -45f, 45f) * MathUtils.degRad;
            vel = new Vector2(-Math.abs(speed * MathUtils.cos(angle)), Math.abs(speed) * MathUtils.sin(angle));
            pos.set(rightP.getX() - size, pos.y);

        }
    }

    private void reset(){
        pos.set(Gdx.graphics.getWidth()/2f - size/2f, Gdx.graphics.getHeight()/2 - size/2);
        speed = minSpeed * (MathUtils.random() < 0.5f ? -1f : 1f);
        float angle = MathUtils.random(-45f, 45f) * MathUtils.degRad;
        vel = new Vector2(speed * MathUtils.cos(angle), speed * MathUtils.sin(angle));
    }

    private void playSound(){
        float random = MathUtils.random();
        if(random < 0.3f)
            blip3.play(soundVolume);
        else if(random < 0.5f)
            blip2.play(soundVolume);
        else
            blip3.play(soundVolume);
    }

    public Vector2 getPos() {
        return pos;
    }

    public Vector2 getVel() {
        return vel;
    }

    public float getSize() {
        return size;
    }

    public void dispose(){
        shapeRenderer.dispose();
    }
}
