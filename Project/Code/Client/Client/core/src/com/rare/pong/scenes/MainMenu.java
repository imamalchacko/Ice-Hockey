package com.rare.pong.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.rare.pong.Pong;
import com.rare.pong.Puck;

public class MainMenu implements Screen {
    private Pong pong;
    private Puck puck;

    private Texture exitButtonNormal;
    private Texture exitButtonOver;
    private Texture play1v1ButtonNormal;
    private Texture play1v1ButtonOver;
    private Texture creditsButtonNormal;
    private Texture creditsButtonOver;
    private Texture playVsAIButtonNormal;
    private Texture playVsAIButtonOver;
    private Texture pongLogo;

    private final float PONGLOGO_Y_PERCENT = .75f;
    private final float PLAY1V1BUTTON_Y_PERCENT = .6f;
    private final float PLAYVSAI_Y_PERCENT = .4f;
    private final float CREDITS_Y_PERCENT = .222f;
    private final float EXIT_Y_PERCENT = .08f;

    public MainMenu(Pong pong) {
        pong.setScreen(new Game1v1(pong));
        this.pong = pong;


        puck = new Puck(null);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        pong.setScreen(new Game1v1(pong));


        puck.glide(delta);
        puck.draw();
    }

    @Override
    public void dispose() {
        puck.dispose();
        exitButtonNormal.dispose();
        exitButtonOver.dispose();
        play1v1ButtonNormal.dispose();
        play1v1ButtonOver.dispose();
        creditsButtonNormal.dispose();
        creditsButtonOver.dispose();
        playVsAIButtonNormal.dispose();
        playVsAIButtonOver.dispose();
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
