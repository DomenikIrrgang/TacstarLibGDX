package de.syncup.tacstar.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.syncup.tacstar.Tacstar;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.foregroundFPS = 144;
		config.width = 1600;
		config.height = 900;
		config.x = 1920 + 1920 / 2 - config.width / 2;
		new LwjglApplication(new Tacstar(), config);
	}
}
