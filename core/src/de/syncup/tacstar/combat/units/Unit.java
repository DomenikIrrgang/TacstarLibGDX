package de.syncup.tacstar.combat.units;

import de.syncup.tacstar.combat.resources.Health;
import de.syncup.tacstar.combat.resources.Mana;
import de.syncup.tacstar.combat.resources.Resource;
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
    private Map<String, StatSet> extraStats = new HashMap<>();
    public StatCalculator statCalculator = new DefaultStatCalculator();

    public Health health;
    public Resource secondaryResource;

    public UnitStatusSet unitStatusSet;

    public Unit(String name, int level) {
        this.health = new Health();
        this.secondaryResource = new Mana();
        this.unitStatusSet = new UnitStatusSet();
        this.name = name;
        this.level = level;
        this.baseStats = new BaseStats(level);
    }

    public StatSet getStats() {
        StatSet tmp = this.baseStats;
        for (StatSet statSet : this.extraStats.values()) {
            tmp = tmp.add(statSet);
        }
        return tmp;
    }
}
