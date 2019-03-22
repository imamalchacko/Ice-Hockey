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
import com.codesinn.icehockey.helpers.FitUpViewport;
import com.codesinn.icehockey.helpers.GameInfo;

public class SignUpStage implements Screen {

    MainClass game;
    Viewport gameViewport;
    Stage stage;
    ImageButton submit,back;
    Label title;
    TextButton fgtPwd,nwAcc;
    TextField username,password;
    Skin skin;

    OrthographicCamera camera=new OrthographicCamera();

    public SignUpStage(MainClass g){
        game=g;
        gameViewport=new FitUpViewport(GameInfo.gWidth,GameInfo.gHeight,camera);

        stage=new Stage(gameViewport,game.batch);
        skin=new Skin(Gdx.files.internal("skins/skin/clean-crispy-ui.json"));

        createAndPositionButtons();

        stage.addActor(back);
        stage.addActor(title);
        stage.addActor(username);
        stage.addActor(password);
        stage.addActor(submit);
        stage.addActor(fgtPwd);
        stage.addActor(nwAcc);

    }

    void createAndPositionButtons(){

        back=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/back 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/back 2.png"))));
        back.setPosition(20,GameInfo.gHeight-80);
        back.setSize(100,80);


        title=new Label("SIGN UP",skin,"default");
        title.setPosition(50,560);
        title.setWidth(400);
        title.setAlignment(Align.center);

        username=new TextField("",skin);
        username.setPosition(50,460);
        username.getStyle().background.setLeftWidth(20);
        username.getStyle().background.setLeftWidth(20);
        username.getStyle().background.setTopHeight(5);
        skin.getFont("font").getData().setScale(.8f);
        username.setWidth(400);
        username.setHeight(60);
        username.setMessageText("rtrt");


        password=new TextField("",skin);
        password.setPosition(50,380);
        password.getStyle().background.setLeftWidth(20);
        password.getStyle().background.setRightWidth(20);
        password.getStyle().background.setTopHeight(5);
        password.setWidth(400);
        password.setHeight(60);
        password.setMessageText("Password");
        password.setPasswordCharacter('*');
        password.setPasswordMode(true);


        submit=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/sign up 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/sign up 2 2.png"))));
        submit.setPosition(50,290);
        submit.setSize(400,80);

        fgtPwd=new TextButton("Forgot Password",skin,"labelbtn");
        fgtPwd.setPosition(50,210);
        fgtPwd.setWidth(400);

        nwAcc=new TextButton("Don't have an account? Sign Up.",skin,"labelbtn");
        nwAcc.setPosition(50,210);
        nwAcc.setWidth(400);


        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new LoginStage(game));
            }
        });


        username.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println(username.getText());
             }
        });

        password.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println(password.getText());
            }
        });

        submit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("fgf");
            }
        });

        fgtPwd.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("pwd");
            }
        });
        nwAcc.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("sign");
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
