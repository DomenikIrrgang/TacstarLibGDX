package de.syncup.tacstar.input;

import de.syncup.tacstar.Tacstar;
import de.syncup.tacstar.debug.ToggleDebugLayerAction;

import java.util.HashMap;
import java.util.Map;

public class Keybinds {

    private Map<KeyPress, Action> keybinds = new HashMap<>();

    public Keybinds(Tacstar tacstar) {
        this.keybinds.put(new KeyPress(Modifier.CTRL, 62), new ToggleDebugLayerAction(tacstar.renderer));
    }

    public Action getAction(int keycode) {
        for (Modifier modifier : Modifier.getPressedModifiers()) {
            if (this.keybinds.get(new KeyPress(modifier, keycode)) != null)
                return this.keybinds.get(new KeyPress(modifier, keycode));
        }
        return null;
    }

}
