package de.syncup.tacstar.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import de.syncup.tacstar.rendering.Point;
import de.syncup.tacstar.rendering.Renderable;
import de.syncup.tacstar.rendering.Renderer;

public class FpsCounter implements Renderable {

    private BitmapFont font = new BitmapFont();
    private Point position;

    public FpsCounter(Point position) {
        this.position = position;
    }

    @Override
    public void render(Renderer renderer) {
        this.font.draw(renderer.getSpriteBatch(), "Fps: " + String.valueOf(this.calculateFps(Gdx.graphics.getDeltaTime())),this.position.x, this.position.y);
    }

    private float calculateFps(float delta) {
        return Math.round(1.0f / delta);
    }

    @Override
    public void dispose() {
        this.font.dispose();
    }

    @Override
    public void update(float delta) {

    }

}
