package de.syncup.tacstar.combat.statuseffects;

import de.syncup.tacstar.combat.Combat;
import de.syncup.tacstar.combat.CombatAction;
import de.syncup.tacstar.combat.units.Unit;

public abstract class StatusEffect {

    protected String name;
    protected int duration;
    protected int remainingDuration;
    protected Unit source;
    protected Unit target;

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.remainingDuration = this.duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getRemainingDuration() {
        return this.remainingDuration;
    }

    public void setRemainingDuration(int remainingDuration) {
        this.remainingDuration = (remainingDuration <= this.duration) ? remainingDuration : this.duration;
    }

    public String getName() {
        return this.name;
    }

    public void refresh() {
        this.remainingDuration = this.duration;
    }

    public abstract String getDescription();

    public void onApply(Combat combat, Unit source, Unit target) {
        this.source = source;
        this.target = target;
    }

    public void onTurnOver(Combat combat) {
        this.remainingDuration -= 1;
        if (this.remainingDuration <= 0)
            this.onExpiration(combat);
    }

    public void onExpiration(Combat combat) {
        // TODO: Remove StatusEffect from target Unit
    }

    public void onDispel(Combat combat, Unit source) {
        // TODO: Remove StatusEffect from target Unit
    }
    public void onRemove(Combat combat) {
        // TODO: Remove StatusEffect from target Unit
    }

    public abstract CombatAction onAbilityCast(CombatAction combatAction);

}
