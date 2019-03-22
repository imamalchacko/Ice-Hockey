package com.codesinn.icehockey.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codesinn.icehockey.MainClass;
import com.codesinn.icehockey.helpers.GameInfo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= 369;
		config.height= 704;
		config.title="Ice Hockey";
		//config.resizable=false;
		config.backgroundFPS=60;
		config.foregroundFPS=60;
		config.x=250;
		config.y=0;
		new LwjglApplication(new MainClass(), config);
	}
}
