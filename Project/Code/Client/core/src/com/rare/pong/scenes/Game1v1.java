package com.rare.pong.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.rare.pong.*;

public class Game1v1 extends Game {
    public Game1v1(Pong pong) {
        super(pong);
        leftP = new PaddleP(15, Gdx.graphics.getHeight()/2 - 100/2, Input.Keys.W, Input.Keys.S,Input.Keys.A, Input.Keys.D, score);
        rightP = new PaddleP(Gdx.graphics.getWidth() - 15f*2, Gdx.graphics.getHeight()/2f - 100f/2, Input.Keys.UP, Input.Keys.DOWN,Input.Keys.LEFT, Input.Keys.RIGHT, score);
    }
}
