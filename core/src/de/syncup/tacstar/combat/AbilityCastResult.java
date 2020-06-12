package de.syncup.tacstar.combat;

import de.syncup.tacstar.combat.abilities.Ability;
import de.syncup.tacstar.combat.units.Unit;

public class AbilityCastResult {
    public AbilityHitType abilityHitType;
    public Ability ability;
    public Unit source;
    public Unit target;
    public Unit originalTarget;
    public int resistAmount = 0;
    public int abilityValue = 0;

    public AbilityCastResult(Ability ability, Unit source, Unit target) {
        this.ability = ability;
        this.source = source;
        this.target = target;
        this.originalTarget = target;
    }

    public boolean isReflected() {
        return !this.target.equals(this.originalTarget);
    }

    public int getActualAbilityValue() {
        return this.abilityValue - this.resistAmount;
    }

}
