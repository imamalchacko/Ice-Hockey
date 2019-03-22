package com.codesinn.icehockey.Scenes.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codesinn.icehockey.MainClass;
import com.codesinn.icehockey.Scenes.MainMenu;
import com.codesinn.icehockey.Scenes.OTP;
import com.codesinn.icehockey.helpers.FitUpViewport;
import com.codesinn.icehockey.helpers.GameInfo;
import com.codesinn.icehockey.helpers.GamePreferences;
import com.codesinn.icehockey.helpers.RestfulServices;

import java.io.IOException;

public class UserHomeStage implements Screen {

    MainClass game;
    Viewport gameViewport;
    Stage stage;
    ImageButton submit,back;
    Label title;
    TextButton errorLabel;
    TextField mobile;
    Skin skin;

    OrthographicCamera camera=new OrthographicCamera();

    public UserHomeStage(MainClass g){
        game=g;
        gameViewport=new FitUpViewport(GameInfo.gWidth,GameInfo.gHeight,camera);

        stage=new Stage(gameViewport,game.batch);
        skin=new Skin(Gdx.files.internal("skins/skin/clean-crispy-ui.json"));

        createAndPositionButtons();

        stage.addActor(back);
        stage.addActor(title);
        stage.addActor(submit);
        stage.addActor(errorLabel);

    }

    void createAndPositionButtons(){


        back=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/back 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/back 2.png"))));
        back.setPosition(20,GameInfo.gHeight-80);
        back.setSize(100,80);


        title=new Label("user home",skin,"default");
        title.setPosition(50,480);
        title.setWidth(400);
        title.setAlignment(Align.center);



        submit=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/sign out 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/sign out 2.png"))));
        submit.setPosition(50,250);
        submit.setSize(400,80);


        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });


        String tmp="You are logged in as:\n"+ GamePreferences.getMobileNumebr();

        errorLabel=new TextButton(tmp,skin,"labelbtn");
        errorLabel.setPosition(50,350);
        errorLabel.setWidth(400);


        submit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GamePreferences.setLoggedStatus("22");
                game.setScreen(new MainMenu(game));
            }
        });


    }




    public Stage getStage(){
        return this.stage;
    }
    public Viewport getViewport(){
        return this.gameViewport;
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
    }

    @Override
    public void resize(int width, int height) {
        gameViewport.update(width,height);
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
        stage.dispose();
    }
}
