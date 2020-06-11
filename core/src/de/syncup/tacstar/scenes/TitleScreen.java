package de.syncup.tacstar.scenes;

import de.syncup.tacstar.rendering.RenderableCollection;
import de.syncup.tacstar.rendering.Scene;

public class TitleScreen implements Scene {

    @Override
    public RenderableCollection getUserInterface() {
        return new RenderableCollection();
    }

    @Override
    public RenderableCollection getWorld() {
        return new RenderableCollection();
    }

    @Override
    public RenderableCollection getBackground() {
        return new RenderableCollection();
    }

    @Override
    public RenderableCollection getLights() {
        return new RenderableCollection();
    }
}
