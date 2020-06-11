package de.syncup.tacstar.combat.resources;

public abstract class Resource {

    private int baseMaximumValue;
    private int extraMaxiumValue;
    private int currentValue;
    private ResourceType type;

    public Resource(ResourceType type, int baseMaximumValue) {
        this.baseMaximumValue = baseMaximumValue;
        this.extraMaxiumValue = 0;
        this.currentValue = baseMaximumValue + this.extraMaxiumValue;
        this.type = type;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public int getMaximumValue() {
        return this.baseMaximumValue + this.extraMaxiumValue;
    }

    public int setMaximumValue(int maximumValue) {
        int difference = maximumValue - this.extraMaxiumValue;
        if (difference != 0) {
            this.extraMaxiumValue = (maximumValue > 0) ? maximumValue : 0;
        }
        return difference;
    }

    public int setCurrentValue(int currentValue) {
        int difference = currentValue - this.currentValue;
        if (difference != 0) {
            this.currentValue = (currentValue > 0) ? currentValue : 0;
            this.currentValue = (currentValue < this.getMaximumValue()) ? currentValue : this.getMaximumValue();
        }
        return difference;
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

    public float getPercentage() {
        return (float) this.currentValue / (float) this.getMaximumValue();
    }

}
