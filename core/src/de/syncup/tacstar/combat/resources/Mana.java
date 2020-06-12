package de.syncup.tacstar.combat.resources;

import de.syncup.tacstar.combat.stats.StatCalculator;

public class Mana extends Resource {

    public Mana(StatCalculator statCalculator) {
        super(statCalculator, ResourceType.MANA, 100);
    }

    @Override
    public int getMaximumValue() {
        return super.getMaximumValue() + this.statCalculator.getMana();
    }

}
