package de.syncup.tacstar.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.syncup.tacstar.debug.DebugLayer;

import java.util.HashMap;
import java.util.Map;

public class DefaultRenderer implements Renderer {

    protected SpriteBatch spriteBatch = new SpriteBatch();
    protected Map<Layer, RenderableCollection> layers = new HashMap<>();
    protected Camera camera = new OrthographicCamera();
    protected Scene scene;
    protected RenderSettings settings = new RenderSettings();

    public DefaultRenderer(Scene scene) {
        this.spriteBatch = new SpriteBatch();
        this.setScene(scene);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.spriteBatch.begin();
        if (this.settings.renderBackground)
            this.layers.get(Layer.BACKGROUND).render(this);
        if (this.settings.renderWorld)
            this.layers.get(Layer.WORLD).render(this);
        this.spriteBatch.end();
        if (this.settings.renderLight)
            this.layers.get(Layer.LIGHT).render(this);
        this.spriteBatch.begin();
        if (this.settings.renderUserInterface)
            this.layers.get(Layer.USER_INTERFACE).render(this);
        if (this.settings.renderDebug)
            this.layers.get(Layer.DEBUG).render(this);
        this.spriteBatch.end();
    }

    @Override
    public RenderSettings getSettings() {
        return this.settings;
    }

    @Override
    public SpriteBatch getSpriteBatch() {
        return this.spriteBatch;
    }

    @Override
    public Camera getCamera() {
        return this.camera;
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
        this.layers.put(Layer.BACKGROUND, scene.getBackground());
        this.layers.put(Layer.WORLD, scene.getWorld());
        this.layers.put(Layer.LIGHT, scene.getLights());
        this.layers.put(Layer.USER_INTERFACE, scene.getUserInterface());
        this.layers.put(Layer.DEBUG, new DebugLayer());
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public void dispose() {
        this.spriteBatch.dispose();
    }

}
