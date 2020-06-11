package de.syncup.tacstar.rendering;

import java.util.ArrayList;
import java.util.List;

public class RenderableCollection implements Renderable {

    private List<Renderable> renderables = new ArrayList<>();

    public void addElement(Renderable renderable) {
        this.renderables.add(renderable);
    }

    public void removeElement(Renderable renderable) {
        this.renderables.remove(renderable);
    }

    @Override
    public void render(Renderer renderer) {
        for (Renderable renderable : this.renderables) {
            renderable.render(renderer);
        }
    }

    @Override
    public void dispose() {
        for (Renderable renderable : this.renderables) {
            renderable.dispose();
        }
    }

    @Override
    public void update(float delta) {
        for (Renderable renderable : this.renderables) {
            renderable.update(delta);
        }
    }
}
