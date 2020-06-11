package de.syncup.tacstar.input;

import com.badlogic.gdx.InputProcessor;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.HashMap;
import java.util.Map;

public class Input implements InputProcessor {

    private Keybinds keybinds;

    public Input(Keybinds keybinds) {
        this.keybinds = keybinds;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Modifier.isModifier(keycode)) {
            Modifier.valueOfKeycode(keycode).setPressed(true);
        } else {
            if (this.keybinds.getAction(keycode) != null)
                this.keybinds.getAction(keycode).execute();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (Modifier.isModifier(keycode))
            Modifier.valueOfKeycode(keycode).setPressed(false);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
