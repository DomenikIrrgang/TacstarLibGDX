package de.syncup.tacstar.combat.abilities;

public abstract class Heal extends Ability {

    public Heal(String name, int coolDown) {
        super(name, coolDown);
    }

    @Override
    public boolean canMiss() {
        return false;
    }
}
