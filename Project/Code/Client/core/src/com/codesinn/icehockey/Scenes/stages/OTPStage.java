package com.codesinn.icehockey.Scenes.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
import com.codesinn.icehockey.Scenes.Login;
import com.codesinn.icehockey.Scenes.MainMenu;
import com.codesinn.icehockey.Scenes.OTP;
import com.codesinn.icehockey.Scenes.UserHome;
import com.codesinn.icehockey.helpers.FitUpViewport;
import com.codesinn.icehockey.helpers.GameInfo;
import com.codesinn.icehockey.helpers.GamePreferences;
import com.codesinn.icehockey.helpers.RestfulServices;

import java.io.IOException;

public class OTPStage implements Screen {

    MainClass game;
    Viewport gameViewport;
    Stage stage;
    ImageButton submit,back;
    Label title;
    TextField otp;
    TextButton errorLabel,otpAlert;
    Skin skin;
    String mobile;

    OrthographicCamera camera=new OrthographicCamera();

    public OTPStage(MainClass g,String mno){
        game=g;
        mobile=mno;
        gameViewport=new FitUpViewport(GameInfo.gWidth,GameInfo.gHeight,camera);
        System.out.println(mobile);
        stage=new Stage(gameViewport,game.batch);
        skin=new Skin(Gdx.files.internal("skins/skin/clean-crispy-ui.json"));

        createAndPositionButtons();

        stage.addActor(back);
        stage.addActor(title);
        stage.addActor(otpAlert);
        stage.addActor(otp);
        stage.addActor(submit);
        stage.addActor(errorLabel);
    }

    void createAndPositionButtons(){


        back=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/back 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/back 2.png"))));
        back.setPosition(20,GameInfo.gHeight-80);
        back.setSize(100,80);



        title=new Label("VERIFY OTP",skin,"default");
        title.setPosition(50,540);
        title.setWidth(400);
        title.setAlignment(Align.center);

        String tmp="OTP has been send to "+mobile;

        otpAlert=new TextButton(tmp,skin,"labelbtn");
        otpAlert.setPosition(50,460);
        otpAlert.setWidth(400);

        otp=new TextField("",skin);
        otp.setPosition(50,380);
        otp.getStyle().background.setLeftWidth(20);
        otp.getStyle().background.setRightWidth(20);
        otp.getStyle().background.setTopHeight(5);
        skin.getFont("font").getData().setScale(.8f);
        otp.setWidth(400);
        otp.setHeight(60);
        otp.setMessageText("One-Time Password");
        otp.setMaxLength(6);
        otp.setAlignment(1);

        submit=new ImageButton(new SpriteDrawable(new Sprite(new Texture("buttons/confirm 1.png"))),new SpriteDrawable(new Sprite(new Texture("buttons/confirm 2.png"))));
        submit.setPosition(50,290);
        submit.setSize(400,80);



        errorLabel=new TextButton("",skin,"labelbtnError");
        errorLabel.setPosition(50,250);
        errorLabel.setWidth(400);





        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Login(game));
                Gdx.input.setOnscreenKeyboardVisible(false);

            }
        });


        otp.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                errorLabel.setText("");
             }
        });



        submit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(new MainMenu(game));
                Gdx.input.setOnscreenKeyboardVisible(false);


                int tmp=validateOTP(otp.getText());
                System.out.println(tmp);
                if(tmp==1){
                    errorLabel.setText("Enter OTP.");
                }
                else if(tmp==2){
                    errorLabel.setText("Invalid OTP.");
                }
                else {

                    GamePreferences.setLoggedStatus("1");
                    GamePreferences.setMobileNumber(mobile);

                    game.setScreen(new UserHome(game));
  /*                  try {
                        String result= RestfulServices.LoginStep2(mobile,otp.getText());
                        //System.out.println("result is: "+result);

                        if(result.equals("1")){
                            //game.setScreen(new OTP(game, otp.getText()));
                            System.out.println("logged in");

                            GamePreferences.setLoggedStatus("1");
                            GamePreferences.setMobileNumber(mobile);

                            game.setScreen(new UserHome(game));

                        }
                        else if(result.equals("0")){
                            errorLabel.setText("Incorrect OTP.");
                        }
                        else{
                            errorLabel.setText("Something went wrong.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        errorLabel.setText("Something went wrong.");
                    }

                    */
                }


            }
        });

    }



    int validateOTP(String otp){
        otp = otp.trim();

        if(otp == null || otp.equals(""))
            return 1;
        if(!otp.matches( "\\d{6}"))
            return 2;

        return 0;
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
