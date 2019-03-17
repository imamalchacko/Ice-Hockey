package com.rare.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rare.pong.scenes.SplashScreen;

public class Pong extends Game {
	public SpriteBatch batch;
	public Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();

		setScreen(new SplashScreen(this));

	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		screen.dispose();
		batch.dispose();

	}
}
