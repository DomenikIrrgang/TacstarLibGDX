package de.syncup.tacstar.combat.resources;

import de.syncup.tacstar.combat.stats.StatCalculator;

public class Health extends Resource {

    public Health(StatCalculator statCalculator) {
        super(statCalculator, ResourceType.HEALTH, 100);
    }

    @Override
    public int getMaximumValue() {
        return super.getMaximumValue() + this.statCalculator.getHealth();
    }

}
