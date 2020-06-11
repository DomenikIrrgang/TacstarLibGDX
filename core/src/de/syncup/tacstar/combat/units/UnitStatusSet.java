package de.syncup.tacstar.combat.units;

import java.util.HashMap;
import java.util.Map;

public class UnitStatusSet {

    private Map<UnitStatus, Integer> statusMap = new HashMap<>();

    public void addUnitStatus(UnitStatus unitStatus) {
        this.statusMap.putIfAbsent(unitStatus, 0);
        this.statusMap.put(unitStatus, this.statusMap.get(unitStatus) + 1);
    }

    public void removeUnitStatus(UnitStatus unitStatus) {
        this.statusMap.putIfAbsent(unitStatus, 0);
        if (this.statusMap.get(unitStatus) > 0)
            this.statusMap.put(unitStatus, this.statusMap.get(unitStatus) - 1);
    }

    public boolean hasUnitStatus(UnitStatus unitStatus) {
        this.statusMap.putIfAbsent(unitStatus, 0);
        return this.statusMap.get(unitStatus) > 0;
    }

    public void clear() {
        this.statusMap = new HashMap<>();
    }
}
