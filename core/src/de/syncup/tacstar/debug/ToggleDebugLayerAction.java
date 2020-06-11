package de.syncup.tacstar.debug;

import de.syncup.tacstar.input.Action;
import de.syncup.tacstar.rendering.Renderer;

public class ToggleDebugLayerAction implements Action {

    private Renderer renderer;

    public ToggleDebugLayerAction(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void execute() {
        this.renderer.getSettings().renderDebug = !this.renderer.getSettings().renderDebug;
    }
}
