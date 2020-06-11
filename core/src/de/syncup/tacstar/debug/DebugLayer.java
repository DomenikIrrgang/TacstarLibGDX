package de.syncup.tacstar.debug;

import com.badlogic.gdx.Gdx;
import de.syncup.tacstar.rendering.Point;
import de.syncup.tacstar.rendering.RenderableCollection;

public class DebugLayer extends RenderableCollection {

    public DebugLayer() {
        this.addElement(new FpsCounter(new Point(0, Gdx.graphics.getHeight())));
    }
}
