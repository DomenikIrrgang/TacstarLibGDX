package de.syncup.tacstar.input;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.List;

public enum Modifier {
    SHIFT(59),
    ALT(57),
    CTRL(129);

    private int keycode;
    private boolean pressed;

    private Modifier(int keycode) {
        this.keycode = keycode;
        this.pressed = false;
    }

    public static Modifier valueOfKeycode(int keycode) {
        for (Modifier modifier : values()) {
            if (modifier.keycode == keycode) {
                return modifier;
            }
        }
        return null;
    }

    public static boolean isModifier(int keycode) {
        return Modifier.valueOfKeycode(keycode) != null;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public int getKeycode() {
        return this.keycode;
    }

    public static List<Modifier> getPressedModifiers() {
        List<Modifier> modifiers = new ArrayList<>();
        for (Modifier modifier : values()) {
            if (modifier.isPressed()) {
                modifiers.add(modifier);
            }
        }
        return modifiers;
    }
}
