package de.syncup.tacstar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import de.syncup.tacstar.combat.AbilityCastResult;
import de.syncup.tacstar.combat.Combat;
import de.syncup.tacstar.combat.DefaultCombatCalculator;
import de.syncup.tacstar.combat.abilities.Fireball;
import de.syncup.tacstar.combat.units.Unit;
import de.syncup.tacstar.input.Input;
import de.syncup.tacstar.input.Keybinds;
import de.syncup.tacstar.rendering.DefaultRenderer;
import de.syncup.tacstar.rendering.Renderer;
import de.syncup.tacstar.rendering.Scene;
import de.syncup.tacstar.scenes.TitleScreen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

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

		Unit suu = new Unit("Suu", 60);
		Unit gamko = new Unit("Gamko", 60);
		Combat combat = new Combat(new DefaultCombatCalculator(), Arrays.asList(suu), Arrays.asList(gamko));
		combat.addCombatAction(new Fireball(), suu, gamko);
		combat.addCombatAction(new Fireball(), gamko, suu);
		for (AbilityCastResult result : combat.calculateRound()) {
			System.out.println(result.abilityValue);
		}
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
