package de.syncup.tacstar.combat.units;

import de.syncup.tacstar.combat.resources.Health;
import de.syncup.tacstar.combat.resources.Mana;
import de.syncup.tacstar.combat.resources.Resource;
import de.syncup.tacstar.combat.resources.ResourceType;
import de.syncup.tacstar.combat.stats.BaseStats;
import de.syncup.tacstar.combat.stats.DefaultStatCalculator;
import de.syncup.tacstar.combat.stats.StatCalculator;
import de.syncup.tacstar.combat.stats.StatSet;

import java.util.HashMap;
import java.util.Map;

public class Unit {

    private String name;
    private int level;

    private StatSet baseStats;
    private StatSet totalStats;
    public StatCalculator statCalculator;

    public Health health;
    public Resource secondaryResource;
    public Resource tertiaryResource;

    public UnitStateSet unitStateSet;

    public Unit(String name, int level) {
        this.name = name;
        this.level = level;
        this.baseStats = new BaseStats(level);
        this.totalStats = new StatSet().add(baseStats);
        this.unitStateSet = new UnitStateSet();
        this.statCalculator = new DefaultStatCalculator(this.totalStats);
        this.health = new Health(this.statCalculator);
        this.secondaryResource = new Mana(this.statCalculator);
        this.tertiaryResource = new Mana(this.statCalculator);
    }

    public StatSet getStats() {
        return this.totalStats;
    }

    public void reduceResource(ResourceType resourceType, int amount) {
        if (!resourceType.equals(ResourceType.HEALTH)) {
            if (this.tertiaryResource.getType().equals(resourceType))
                amount += this.tertiaryResource.decreaseCurrentValue(amount);
            if (this.secondaryResource.getType().equals(resourceType))
                this.secondaryResource.decreaseCurrentValue(amount);
        } else {
            if (this.secondaryResource.getType().equals(resourceType))
                amount += this.secondaryResource.decreaseCurrentValue(amount);
            this.health.decreaseCurrentValue(amount);
        }
    }
}
