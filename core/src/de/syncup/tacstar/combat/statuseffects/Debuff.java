package de.syncup.tacstar.combat.statuseffects;

public abstract class Debuff extends StatusEffect {

    public Debuff(String name, int duration) {
        super(name, duration);
    }

    public abstract DebuffType getType();
}
