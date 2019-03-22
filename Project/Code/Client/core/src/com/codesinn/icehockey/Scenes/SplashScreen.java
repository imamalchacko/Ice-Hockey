package com.codesinn.icehockey.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codesinn.icehockey.MainClass;
import com.codesinn.icehockey.helpers.GameInfo;
import com.badlogic.gdx.utils.TimeUtils;


public class SplashScreen implements Screen {

    MainClass game;
    Sprite sprite=new Sprite(new Texture("game_main.png"));




    OrthographicCamera cam;
    Viewport viewport;
    private long startTime;

    //private Integer a=2;



    public SplashScreen(MainClass m){
        this.game=m;
        cam=new OrthographicCamera();
        viewport=new FitViewport(GameInfo.gWidth,GameInfo.gWidth,cam);
        startTime = TimeUtils.millis();

            //GamePreferences.setName("amal");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.13f, .13f, .15f, .1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(cam.combined);
        game.batch.begin();
        game.batch.draw(sprite, -GameInfo.gWidth/2f+55,10,400,70);

        game.batch.end();

        //System.out.println(GamePreferences.getName());

        if(TimeUtils.timeSinceMillis(startTime) >= 1500L) {
            game.setScreen(new MainMenu(game));
            startTime++;
        }

    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
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
