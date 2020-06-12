package de.syncup.tacstar.combat;

import de.syncup.tacstar.combat.abilities.Ability;
import de.syncup.tacstar.combat.units.Unit;

public class DefaultCombatCalculator implements CombatCalculator {

    @Override
    public int getAbilityValue(Ability ability, Unit source, Unit target, boolean critical) {
        return 50;
    }

    @Override
    public int getResistAmount(int value, Unit source, Unit target) {
        return 10;
    }

    @Override
    public int getCriticalAmount(int value, Unit source, Unit target) {
        return 0;
    }

    @Override
    public int getAbilityCost(Ability ability, Unit source) {
        return 10;
    }

    @Override
    public boolean abilityHit(Ability ability, Unit source, Unit target) {
        return false;
    }

    @Override
    public boolean abilityDodge(Ability ability, Unit source, Unit target) {
        return false;
    }

    @Override
    public boolean abilityParry(Ability ability, Unit source, Unit target) {
        return false;
    }

    @Override
    public boolean abilityCrit(Ability ability, Unit source, Unit target) {
        return false;
    }

    @Override
    public boolean abilityReflect(Ability ability, Unit source, Unit target) {
        return true;
    }

    @Override
    public boolean abilityCastable(Ability ability, Unit source) {
        return true;
    }
}
