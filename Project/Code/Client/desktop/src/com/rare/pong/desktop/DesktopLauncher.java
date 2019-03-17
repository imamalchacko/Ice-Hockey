package com.rare.pong.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rare.pong.Pong;

public class DesktopLauncher {
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1080;
		config.height = 466;
		config.vSyncEnabled = true;
		config.resizable = false;
		config.foregroundFPS=60;
		config.backgroundFPS=60;
		config.title = "Ice Hockey";
		new LwjglApplication(new Pong(), config);
	}
}
