package de.syncup.tacstar.combat;

import de.syncup.tacstar.combat.abilities.Ability;
import de.syncup.tacstar.combat.units.Unit;

public class CombatAction {

    public Unit source;
    public Unit target;
    public Ability ability;

    public CombatAction(Ability ability, Unit source, Unit target) {
        this.source = source;
        this.target = target;
        this.ability = ability;
    }

}
