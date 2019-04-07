package com.codesinn.icehockey;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class MyActor extends Actor {
    Sprite sprite=new Sprite(new Texture(Gdx.files.internal("puck.png")));

    public MyActor() {
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);


        addListener(new InputListener() {

            public boolean keyDown(InputEvent event, int keycode){
                int width=Gdx.graphics.getWidth();
                int height=Gdx.graphics.getHeight();
                int move_margin=105;
                int move_speed=2;


                if(keycode == Input.Keys.RIGHT){

                        MoveByAction mba = new MoveByAction();
                        mba.setAmount(move_margin, 0f);
                        mba.setDuration(move_speed);
                        MyActor.this.addAction(mba);


                }
                else if(keycode == Input.Keys.LEFT){
                    MoveByAction mba=new MoveByAction();
                    mba.setAmount(-move_margin,0f);
                    mba.setDuration(move_speed);
                    MyActor.this.addAction(mba);
                }
                else if(keycode == Input.Keys.UP){
                    MoveByAction mba=new MoveByAction();
                    mba.setAmount(0f,move_margin);
                    mba.setDuration(move_speed);
                    MyActor.this.addAction(mba);
                }
                else if(keycode == Input.Keys.DOWN){
                    MoveByAction mba=new MoveByAction();
                    mba.setAmount(0f,-move_margin);
                    mba.setDuration(move_speed);
                    MyActor.this.addAction(mba);
                }
                return true;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        sprite.setSize(50f,50f);
        sprite.draw(batch);

    }
}
