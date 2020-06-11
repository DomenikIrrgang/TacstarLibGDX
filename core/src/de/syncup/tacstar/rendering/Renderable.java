package de.syncup.tacstar.rendering;

import com.badlogic.gdx.utils.Disposable;

public interface Renderable extends Disposable, Updateable {
    void render(Renderer renderer);
}
