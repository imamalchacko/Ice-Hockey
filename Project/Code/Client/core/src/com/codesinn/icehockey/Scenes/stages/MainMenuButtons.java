package com.codesinn.icehockey.Scenes.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codesinn.icehockey.MainClass;
import com.codesinn.icehockey.Scenes.Login;
import com.codesinn.icehockey.Scenes.UserHome;
import com.codesinn.icehockey.helpers.FitUpViewport;
import com.codesinn.icehockey.helpers.GameInfo;
import com.codesinn.icehockey.helpers.GamePreferences;

public class MainMenuButtons implements Screen  {

    public MainClass game;
    Viewport gameViewport;
    Stage stage;
    ImageButton play1,play2,myAcc,options,exit;
    TextField txt;
    Skin skin;
    Dialog dialog;

    public MainMenuButtons(MainClass g){
        game=g;
        gameViewport=new FitUpViewport(GameInfo.gWidth,GameInfo.gHeight,new OrthographicCamera());

        stage=new Stage(gameViewport,game.batch);
        skin=new Skin(Gdx.files.internal("skins/skin/clean-crispy-ui.json"));

        createAndPositionButtons();

        stage.addActor(play1);
        stage.addActor(play2);
        stage.addActor(myAcc);
        stage.addActor(options);
        stage.addActor(exit);

        stage.addActor(txt);

    }


    void createAndPositionButtons(){

        play1=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/1 player 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/1 player 2.png"))));
        play2=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/2 player 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/2 player 2.png"))));
        myAcc=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/my acc 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/my acc 2.png"))));
        options=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/options 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/options 2.png"))));
        exit=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/exit 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/exit 2.png"))));


        txt=new TextField("",skin );
        txt.setPosition(100,100);
        txt.setWidth(300);
        txt.setHeight(60);

        txt.setPosition(0,0);
        txt.setWidth(0);
        txt.setHeight(0);

        dialog = new Dialog("", skin, "other") {
            public void result(Object obj) {
                if(obj.equals(true)){
                    Gdx.app.exit();
                }
                else{
                    remove();
                }
            }
        };



        dialog.text("are you sure want to exit?");
        dialog.button("Yes", true);
        dialog.button("No", false);



        play1.setPosition((GameInfo.gWidth/2)-200,GameInfo.gHeight-400);
        play1.setSize(400,80);

        play2.setPosition((GameInfo.gWidth/2)-200,GameInfo.gHeight-480);
        play2.setSize(400,80);

        myAcc.setPosition((GameInfo.gWidth/2)-200,GameInfo.gHeight-560);
        myAcc.setSize(400,80);

        options.setPosition((GameInfo.gWidth/2)-200,GameInfo.gHeight-640);
        options.setSize(400,80);

        exit.setPosition((GameInfo.gWidth/2)-200,GameInfo.gHeight-720);
        exit.setSize(400,80);

        play1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("1 Player");
            }
        });

        play2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("2 Player");
            }
        });

        myAcc.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {


                if(GamePreferences.getLoggedStatus().equals("1")){
                    game.setScreen(new UserHome(game));
                }
                else {
                    game.setScreen(new Login(game));
                }

                //stage.dispose();

               // System.out.println(GamePreferences.getLoggedStatus());
               // System.out.println(GamePreferences.getMobileNumebr());


            }
        });



        txt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println(txt.getText());
            }
        });
        options.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("jbhj");
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dialog.show(stage);
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
