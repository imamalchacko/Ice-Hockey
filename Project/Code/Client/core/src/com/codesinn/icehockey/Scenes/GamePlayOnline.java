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

public class GamePlayOnline implements Screen {

    MainClass game;
    //Texture texture=new Texture("icon.png");
    Sprite base=new Sprite(new Texture("table.png"));
    Sprite boundaries=new Sprite(new Texture("table-top.png"));
    //Sprite base=new Sprite(new Texture("base.png"));
    OrthographicCamera cam;
    Viewport viewport;

    public GamePlayOnline(MainClass m){
        this.game=m;
        cam=new OrthographicCamera();
        viewport=new FitViewport(GameInfo.gWidth, GameInfo.gHeight,cam);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(cam.combined);
        game.batch.begin();
        game.batch.draw(base,-(GameInfo.gWidth/2),-(GameInfo.gHeight/2),GameInfo.gWidth,GameInfo.gHeight);
        game.batch.draw(boundaries,-(GameInfo.gWidth/2),-(GameInfo.gHeight/2),GameInfo.gWidth,GameInfo.gHeight);

        game.batch.end();
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
