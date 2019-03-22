package com.codesinn.icehockey.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.codesinn.icehockey.MainClass;
import com.codesinn.icehockey.Scenes.stages.MainMenuButtons;
import com.codesinn.icehockey.Scenes.stages.UserHomeStage;

public class MainMenu implements Screen {

    MainClass game;
    MainMenuButtons btns;



    public MainMenu(MainClass m){
        game=m;
        btns=new MainMenuButtons(game);

        Gdx.input.setInputProcessor(btns.getStage());

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.13f, .13f, .15f, .1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.end();

        game.batch.setProjectionMatrix(btns.getStage().getCamera().combined);
        btns.getStage().draw();


    }

    @Override
    public void resize(int width, int height) {
        btns.getStage().getViewport().update(width,height);
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
