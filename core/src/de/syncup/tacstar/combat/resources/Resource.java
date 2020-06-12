package de.syncup.tacstar.combat.resources;

import de.syncup.tacstar.combat.stats.StatCalculator;

public abstract class Resource {

    protected StatCalculator statCalculator;
    private int baseMaximumValue;
    private int currentValue;
    private ResourceType type;

    public Resource(StatCalculator statCalculator, ResourceType type, int baseMaximumValue) {
        this.statCalculator = statCalculator;
        this.baseMaximumValue = baseMaximumValue;
        this.currentValue = this.getMaximumValue();
        this.type = type;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public int getMaximumValue() {
        return this.baseMaximumValue;
    }

    public int setMaximumValue(int maximumValue) {
        int difference = maximumValue - this.getMaximumValue();
        if (difference != 0) {
            this.baseMaximumValue = (maximumValue > 0) ? maximumValue : 0;
        }
        return difference - (currentValue - this.getMaximumValue());
    }

    public int setCurrentValue(int currentValue) {
        int difference = currentValue - this.currentValue;
        if (difference != 0) {
            this.currentValue = (currentValue > 0) ? currentValue : 0;
            this.currentValue = (currentValue < this.getMaximumValue()) ? currentValue : this.getMaximumValue();
        }
        return difference - (currentValue - this.currentValue);
    }

    public int increaseCurrentValue(int change) {
        return this.setCurrentValue(this.getCurrentValue() + change);
    }

    public int increaseMaximumValue(int change) {
        return this.setMaximumValue(this.getMaximumValue() + change);
    }

    public int decreaseCurrentValue(int change) {
        return this.increaseCurrentValue(-change);
    }

    public int decreaseMaximumValue(int change) {
        return this.increaseMaximumValue(-change);
    }

    public ResourceType getType() {
        return this.type;
    }

    public float getPercentage() {
        return (float) this.currentValue / (float) this.getMaximumValue();
    }

}
