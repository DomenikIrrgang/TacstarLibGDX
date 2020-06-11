package de.syncup.tacstar.combat.abilities;

import de.syncup.tacstar.combat.resources.ResourceType;

public abstract class Ability {

    private String name;

    private int coolDown;
    private int remainingCoolDown;

    public Ability(String name, int coolDown) {
        this.name = name;
        this.coolDown = coolDown;
        this.remainingCoolDown = 0;
    }

    public int getCoolDown() {
        return this.coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getRemainingCoolDown() {
        return this.remainingCoolDown;
    }

    public void setRemainingCoolDown(int remainingCoolDown) {
        this.remainingCoolDown = remainingCoolDown;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reset() {
        this.remainingCoolDown = 0;
    }

    public abstract String getTooltip();
    public abstract boolean canCrit();
    public abstract float getCriticalChance();
    public abstract float getCriticalEffect();
    public abstract boolean canMiss();
    public abstract boolean isReflectable();
    public abstract boolean canBeDodged();
    public abstract boolean canBeParried();
    public abstract boolean canBeResisted();
    public abstract ResourceType getResourceType();
    public abstract int getResourceCost();
    public abstract TargetType getTargetType();
    public abstract int getAbilityValue();
    public abstract void execute();
}
