package de.syncup.tacstar.combat;

import de.syncup.tacstar.combat.abilities.Ability;
import de.syncup.tacstar.combat.units.Unit;

public interface CombatCalculator {
    int calculateAbilityCost(Ability ability, Unit source, Unit target);
    int getAbilityValue(Ability ability, Unit source, Unit target);
    int getResistAmount(int value, Unit source, Unit target);
    int getCriticalAmount(int value, Unit source, Unit target);
    boolean abilityHit(Ability ability, Unit source, Unit target);
    boolean abilityDodge(Ability ability, Unit source, Unit target);
    boolean abilityParry(Ability ability, Unit source, Unit target);
    boolean abilityCrit(Ability ability, Unit source, Unit target);
    boolean abilityReflect(Ability ability, Unit source, Unit target);
    boolean abilityCastable(Ability ability, Unit source);
}
