package com.codesinn.icehockey.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codesinn.icehockey.MainActivity;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=1280;
		config.height=720;
		config.foregroundFPS=60;
		config.backgroundFPS=60;
		new LwjglApplication(new MainActivity(), config);
	}
}
