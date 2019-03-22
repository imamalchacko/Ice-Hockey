package com.codesinn.icehockey;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codesinn.icehockey.Scenes.GameOnline;
import com.codesinn.icehockey.Scenes.MainMenu;
import com.codesinn.icehockey.Scenes.SplashScreen;

public class MainClass extends Game {
	public SpriteBatch batch;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new SplashScreen(this));

		//setScreen(new MainMenu(this));

		// setScreen(new GameOnline(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
