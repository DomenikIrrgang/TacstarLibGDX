package de.syncup.tacstar.combat.units;

import java.util.HashMap;
import java.util.Map;

public class UnitStateSet {

    private Map<UnitState, Integer> statusMap = new HashMap<>();

    public void addUnitStatus(UnitState unitState) {
        this.statusMap.putIfAbsent(unitState, 0);
        this.statusMap.put(unitState, this.statusMap.get(unitState) + 1);
    }

    public void removeUnitStatus(UnitState unitState) {
        this.statusMap.putIfAbsent(unitState, 0);
        if (this.statusMap.get(unitState) > 0)
            this.statusMap.put(unitState, this.statusMap.get(unitState) - 1);
    }

    public boolean hasUnitStatus(UnitState unitState) {
        this.statusMap.putIfAbsent(unitState, 0);
        return this.statusMap.get(unitState) > 0;
    }

    public void clear() {
        this.statusMap = new HashMap<>();
    }
}
