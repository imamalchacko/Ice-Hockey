package com.codesinn.icehockey.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.codesinn.icehockey.MainClass;
import com.codesinn.icehockey.Scenes.stages.LoginStage;
import com.codesinn.icehockey.Scenes.stages.OTPStage;
import com.codesinn.icehockey.Scenes.stages.SignUpStage;

public class OTP implements Screen {

    MainClass game;
    OTPStage otp;
    SignUpStage signUp;
    String mobile;


    public OTP(MainClass m,String mno){
        this.game=m;
        mobile=mno;
        otp=new OTPStage(game,mno);
        //signUp=new SignUpStage(game);

        Gdx.input.setInputProcessor(otp.getStage());
       // Gdx.input.setInputProcessor(signUp.getStage());
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
        otp.getStage().draw();

        //signUp.getStage().draw();
        otp.getStage().draw();


        game.batch.setProjectionMatrix(otp.getStage().getCamera().combined);
        //game.batch.setProjectionMatrix(signUp.getStage().getCamera().combined);
    }

    @Override
    public void resize(int width, int height) {
        otp.getStage().getViewport().update(width,height);
        //signUp.getStage().getViewport().update(width,height);
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
