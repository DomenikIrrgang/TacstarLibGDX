package de.syncup.tacstar.rendering;

import com.badlogic.gdx.Screen;

import java.util.List;

public interface Scene {
    RenderableCollection getUserInterface();
    RenderableCollection getWorld();
    RenderableCollection getBackground();
    RenderableCollection getLights();
}
