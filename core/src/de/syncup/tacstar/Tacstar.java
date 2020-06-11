package de.syncup.tacstar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.controllers.Controllers;
import de.syncup.tacstar.combat.stats.DefaultStatCalculator;
import de.syncup.tacstar.combat.stats.Stat;
import de.syncup.tacstar.combat.stats.StatCalculator;
import de.syncup.tacstar.combat.units.Unit;
import de.syncup.tacstar.eventbus.Event;
import de.syncup.tacstar.eventbus.EventBus;
import de.syncup.tacstar.eventbus.EventListener;
import de.syncup.tacstar.input.Input;
import de.syncup.tacstar.input.Keybinds;
import de.syncup.tacstar.rendering.DefaultRenderer;
import de.syncup.tacstar.rendering.Renderer;
import de.syncup.tacstar.rendering.Scene;
import de.syncup.tacstar.scenes.TitleScreen;

import java.awt.*;

public class Tacstar extends ApplicationAdapter {

	public Renderer renderer;
	public Scene scene;
	public Input input;
	
	@Override
	public void create () {
		this.renderer = new DefaultRenderer(new TitleScreen());
		this.scene = new TitleScreen();
		this.input = new Input(new Keybinds(this));
		Gdx.input.setInputProcessor(this.input);
	}

	@Override
	public void render () {
		this.renderer.render();
	}
	
	@Override
	public void dispose () {
		this.renderer.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
