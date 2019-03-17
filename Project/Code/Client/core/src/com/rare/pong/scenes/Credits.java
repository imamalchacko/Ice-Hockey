package com.rare.pong.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.rare.pong.Pong;
import com.rare.pong.Puck;

public class Credits implements Screen {
    private Pong pong;


    public Credits(Pong pong){
        this.pong = pong;
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void dispose() {
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
