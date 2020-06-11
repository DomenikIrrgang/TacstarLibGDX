package de.syncup.tacstar.input;

import java.security.Key;

public class KeyPress {
    public Modifier modifier;
    public int keycode;

    public KeyPress(Modifier modifier, int keycode) {
        this.modifier = modifier;
        this.keycode = keycode;
    }

    @Override
    public int hashCode() {
        String hashCode = "";
        if (this.modifier != null)
            hashCode += this.modifier.getKeycode();
        hashCode += keycode;
        return Integer.valueOf(hashCode);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof KeyPress && ((KeyPress) obj).keycode == this.keycode && ((KeyPress) obj).modifier == this.modifier;
    }
}

