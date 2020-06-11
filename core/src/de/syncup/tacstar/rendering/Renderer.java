package de.syncup.tacstar.rendering;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public interface Renderer extends Disposable {
    void render();
    RenderSettings getSettings();
    SpriteBatch getSpriteBatch();
    Camera getCamera();
    void setScene(Scene scene);
    Scene getScene();
}
