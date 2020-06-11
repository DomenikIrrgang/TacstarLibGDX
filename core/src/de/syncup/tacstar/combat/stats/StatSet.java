package de.syncup.tacstar.combat.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatSet {

    private Map<Stat, Integer> stats = new HashMap<>();

    public void setStat(Stat stat, int value) {
        this.stats.put(stat, value);
    }

    public int getStat(Stat stat) {
        return (this.stats.get(stat) != null) ? this.stats.get(stat) : 0;
    }

    public Set<Stat> getStats() {
        return this.stats.keySet();
    }

    public StatSet add(StatSet statSet) {
        StatSet result = new StatSet();
        for (Stat stat : this.getStats()) {
            result.setStat(stat, this.getStat(stat));
        }
        for (Stat stat : statSet.getStats()) {
            result.setStat(stat, result.getStat(stat) + statSet.getStat(stat));
        }
        return result;
    }

}
