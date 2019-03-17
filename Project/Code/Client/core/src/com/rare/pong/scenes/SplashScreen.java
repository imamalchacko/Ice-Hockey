package com.rare.pong.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.rare.pong.Pong;

public class SplashScreen implements Screen {
    private Pong pong;
    private Texture splashScreenTexture;
    private long startTime;

    public SplashScreen(Pong pong) {
        pong.setScreen(new MainMenu(pong));
       this.pong = pong;

    }

    @Override
    public void render(float delta) {

            pong.setScreen(new MainMenu(pong));
    }

    @Override
    public void dispose() {
        splashScreenTexture.dispose();
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
